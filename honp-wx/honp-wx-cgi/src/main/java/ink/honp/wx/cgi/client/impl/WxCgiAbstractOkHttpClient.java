package ink.honp.wx.cgi.client.impl;

import ink.honp.core.constant.SymbolicConstant;
import ink.honp.core.util.ThreadUtil;
import ink.honp.wx.cgi.client.WxCgiClient;
import ink.honp.wx.cgi.config.WxClientConfig;
import ink.honp.wx.core.client.WxAbstractOkHttpClient;
import ink.honp.wx.cgi.entity.response.WxAccessTokenResponse;
import ink.honp.wx.core.exception.WxError;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author jeffchen
 * date    2024/01/09 11:19
 */
@Slf4j
public abstract class WxCgiAbstractOkHttpClient extends WxAbstractOkHttpClient implements WxCgiClient {

    public static final int MAX_RETRY_COUNT = 3;
    private static final long LOCK_TIMEOUT_MS = 100;
    private static final String ACCESS_TOKEN = "access_token";

    private final String clientTag;
    private final WxClientConfig config;

    protected WxCgiAbstractOkHttpClient(WxClientConfig config) {
        super(config.getClientTag(), config.getTimeout(), config.getLevel());

        this.clientTag = config.getClientTag();
        this.config = config;
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
            WxAccessTokenResponse wxAccessTokenResponse = doGetAccessToken();
            config.refreshAccessToken(wxAccessTokenResponse.getAccessToken(), wxAccessTokenResponse.getExpiresIn());

            return wxAccessTokenResponse.getAccessToken();
        } catch (InterruptedException e) {
            log.warn("[{}] accessToken lock interrupted error.", config.getClientTag(), e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

        return StringUtils.EMPTY;
    }

    public abstract WxAccessTokenResponse doGetAccessToken() throws WxException;

    @Override
    public <T> T execute(WxRequestExecutor<Response> executor, String url,Object data, WxResponseHandler<T> responseHandler) {
        return executeInternal(executor, url, data, responseHandler, true);
    }

    @Override
    public  <T> T execute(WxRequestExecutor<Response> executor, String url, Object data,
                                  WxResponseHandler<T> responseHandler, int retryCount, int maxRetryCount)
            throws WxException{
        try {
            Response response = executor.execute(url, data);
            return responseHandler.handle(response);
        } catch (WxException | IOException ex) {
            WxException wxEp;
            if (ex instanceof IOException) {
                log.error("[{}] request io error.", clientTag, ex);
                wxEp = new WxException(WxError.SERVER_ERROR);
            } else {
                wxEp = (WxException) ex;
            }

            if (maxRetryCount < 0) {
                throw wxEp;
            }

            if ((++retryCount) > maxRetryCount) {
                log.error("[{}] retry max count [{}].",clientTag, maxRetryCount);
                throw wxEp;
            }

            if (WxError.SERVER_ERROR.getCode().equals(wxEp.getCode())) {
                int sleepTime = 100 * (1 << retryCount);
                log.info("[{}] server or IO error, [{}] ms retry request", clientTag, sleepTime);
                ThreadUtil.sleep(sleepTime);
                execute(executor, url, data, responseHandler, retryCount, maxRetryCount);
            }
            throw wxEp;
        }
    }

    private <T> T executeInternal(WxRequestExecutor<Response> executor, String url, Object data,
                          WxResponseHandler<T> responseHandler, boolean autoRefreshAccessToken) {
        String accessToken = getAccessToken(false);
        String urlWithAccessToken = urlConcatAccessToken(url, accessToken);

        try {
            return execute(executor, urlWithAccessToken, data, responseHandler, 0, MAX_RETRY_COUNT);
        } catch (WxException ex) {
            // invalid accessToken
            if (WxError.isInvalidToken(ex.getCode())) {
                log.warn("[{}] access_token invalid, refresh access_token", clientTag);
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
                    return executeInternal(executor, url, data, responseHandler, false);
                }
            }
            throw ex;
        }
    }

    private String urlConcatAccessToken(String url, String accessToken) {
        String separator = url.contains(SymbolicConstant.QUESTION) ?
                SymbolicConstant.AMPLE : SymbolicConstant.QUESTION;

        return url + separator + ACCESS_TOKEN + SymbolicConstant.EQUAL + accessToken;
    }
}
