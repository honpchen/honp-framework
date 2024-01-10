package ink.honp.wx.core.client;

import ink.honp.core.constant.SymbolicConstant;
import ink.honp.core.http.interceptor.OkHttpDefaultLogInterceptor;
import ink.honp.core.util.JacksonUtil;
import ink.honp.core.util.ThreadUtil;
import ink.honp.wx.core.entity.WxConfig;
import ink.honp.wx.core.exception.WxError;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.util.http.convert.ResponseConverter;
import ink.honp.wx.core.util.http.convert.SimpleResponseConvert;
import ink.honp.wx.core.util.http.executor.RequestExecutor;
import ink.honp.wx.core.util.http.executor.SimpleGetRequestExecutor;
import ink.honp.wx.core.util.http.executor.SimplePostRequestExecutor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author jeff chen
 * @since 2024-01-01 22:07
 */
@Slf4j
@Getter
public abstract class WxAbstractOkHttpClient implements WxClient<Response, OkHttpClient> {

    private static final int MAX_RETRY_COUNT = 3;
    private static final long LOCK_TIMEOUT_MS = 100;
    private static final String ACCESS_TOKEN = "access_token";

    private final String tag;
    private final WxConfig config;
    private final OkHttpClient httpClient;
    private final SimpleGetRequestExecutor simpleGetRequestExecutor;
    private final SimplePostRequestExecutor simplePostRequestExecutor;

    private static final SimpleResponseConvert DEFAULT_CONVERT = new SimpleResponseConvert();

    protected WxAbstractOkHttpClient(String clientTag, WxConfig config) {
        this.tag = clientTag;
        this.config = config;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(config.getTimeout(), TimeUnit.SECONDS)
                .readTimeout(config.getTimeout(), TimeUnit.SECONDS)
                .writeTimeout(config.getTimeout(), TimeUnit.SECONDS)
                .addInterceptor(new OkHttpDefaultLogInterceptor(clientTag, config.getLevel()))
                .build();

        this.simpleGetRequestExecutor = new SimpleGetRequestExecutor(this.httpClient);
        this.simplePostRequestExecutor = new SimplePostRequestExecutor(this.httpClient);
    }

    @Override
    public String getAccessToken(boolean forceRefresh) {
        if (!forceRefresh && config.accessTokenNotExpired()) {
            return config.getAccessToken();
        }

        Lock lock = config.getAccessTokenLock();
        try {
            boolean isLocked;
            do {
                isLocked = lock.tryLock(LOCK_TIMEOUT_MS, TimeUnit.MICROSECONDS);
                if (!forceRefresh && config.accessTokenNotExpired()) {
                    return config.getAccessToken();
                }
            }while (!isLocked);
            // 刷新 accessToken
            refreshAccessToken();

            return config.getAccessToken();
        } catch (InterruptedException e) {
            log.warn("[{}] accessToken lock interrupted error.", tag, e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

        return StringUtils.EMPTY;
    }

    /**
     * 刷新 access_token
     */
    public abstract void refreshAccessToken();

    @Override
    public String get(String url, Object queryParams) {
        return executeWithAccessToken(simpleGetRequestExecutor, url, queryParams, DEFAULT_CONVERT);
    }

    @Override
    public <T> T get(String url, Object queryParams, Class<T> repClz) {
        String response = executeWithAccessToken(simpleGetRequestExecutor, url, queryParams, DEFAULT_CONVERT);
        if (StringUtils.isBlank(response)) {
            return null;
        }
        return JacksonUtil.toBean(response, repClz);
    }

    @Override
    public String post(String url, Object data) {
        return executeWithAccessToken(simplePostRequestExecutor, url, data, DEFAULT_CONVERT);
    }

    @Override
    public <T> T post(String url, Object data, Class<T> repClz) {
        String response = executeWithAccessToken(simplePostRequestExecutor, url, data, DEFAULT_CONVERT);
        if (StringUtils.isBlank(response)) {
            return null;
        }
        return JacksonUtil.toBean(response, repClz);
    }


    @Override
    public <T> T executeWithAccessToken(RequestExecutor<Response> executor, String url,
                                        Object data, ResponseConverter<Response, T> repConverter) throws WxException {
        return executeInternal(executor, url, data, repConverter, true);
    }

    @Override
    public <T> T execute(RequestExecutor<Response> executor, String url,
                         Object data, ResponseConverter<Response, T> repConverter) throws WxException {
        return doExecute(executor, url, data, repConverter, 0, MAX_RETRY_COUNT);
    }

    @Override
    public OkHttpClient getHttpClient() {
        return httpClient;
    }


    private <T> T executeInternal(RequestExecutor<Response> executor, String url, Object data,
                                  ResponseConverter<Response, T> repConverter, boolean autoRefreshAccessToken) {
        String accessToken = getAccessToken(false);
        String urlWithAccessToken = urlConcatAccessToken(url, accessToken);

        try {
            return doExecute(executor, urlWithAccessToken, data, repConverter, 0, MAX_RETRY_COUNT);
        } catch (WxException ex) {
            // invalid accessToken
            if (WxError.isInvalidToken(ex.getCode())) {
                log.warn("[{}] access_token invalid, refresh access_token", tag);
                Lock tokenLock = config.getAccessTokenLock();
                tokenLock.lock();
                try {
                    if (accessToken.equals(config.getAccessToken())) {
                        // 强制过期 accessToken, 下次请求时会自动刷新
                        config.expiredAccessToken();
                    }
                } finally {
                    tokenLock.unlock();
                }

                if (autoRefreshAccessToken) {
                    return executeInternal(executor, url, data, repConverter, false);
                }
            }
            throw ex;
        }
    }

    private  <T> T doExecute(RequestExecutor<Response> executor, String url, Object data,
                             ResponseConverter<Response, T> repConverter, int retryCount, int maxRetryCount)
            throws WxException{
        try {
            Response response = executor.execute(url, data);
            return repConverter.convert(response);
        } catch (WxException | IOException ex) {
            WxException wxEp;
            if (ex instanceof IOException) {
                log.error("[{}] request io error.", tag, ex);
                wxEp = new WxException(WxError.SERVER_ERROR);
            } else {
                wxEp = (WxException) ex;
            }

            if (maxRetryCount < 0) {
                throw wxEp;
            }

            if ((++retryCount) > maxRetryCount) {
                log.error("[{}] retry max count [{}].",tag, maxRetryCount);
                throw wxEp;
            }

            if (WxError.SERVER_ERROR.getCode().equals(wxEp.getCode())) {
                int sleepTime = 100 * (1 << retryCount);
                log.info("[{}] server or IO error, [{}] ms retry request", tag, sleepTime);
                ThreadUtil.sleep(sleepTime);
                doExecute(executor, url, data, repConverter, retryCount, maxRetryCount);
            }
            throw wxEp;
        }
    }

    private String urlConcatAccessToken(String url, String accessToken) {
        String separator = url.contains(SymbolicConstant.QUESTION) ?
                SymbolicConstant.AMPLE : SymbolicConstant.QUESTION;

        return url + separator + ACCESS_TOKEN + SymbolicConstant.EQUAL + accessToken;
    }
}
