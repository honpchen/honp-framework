package ink.honp.wx.miniapp.client.impl;

import ink.honp.core.constant.SymbolicConstant;
import ink.honp.core.util.JacksonUtil;
import ink.honp.core.util.ThreadUtil;
import ink.honp.wx.core.client.impl.WxAbstractClientImpl;
import ink.honp.wx.core.constant.WxConstant;
import ink.honp.wx.core.constant.WxGrantType;
import ink.honp.wx.core.entity.WxTokenInfo;
import ink.honp.wx.core.entity.request.WxAccessTokenRequest;
import ink.honp.wx.core.exception.WxError;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.response.user.WxaSessionInfoResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author jeff chen
 * @since 2024-01-01 17:45
 */
@Slf4j
public class WxaClientImpl extends WxAbstractClientImpl implements WxaClient {

    private static final String TAG = "WXA";

    private static final long LOCK_TIMEOUT_MS = 100;
    private static final int MAX_RETRY_COUNT = 3;
    private static final int NO_RETRY = -1;

    private final WxaConfig wxaConfig;

    public WxaClientImpl(WxaConfig wxaConfig) {
        this.wxaConfig = wxaConfig;
    }

    @Override
    public WxaConfig getConfig() {
        return this.wxaConfig;
    }

    @Override
    public String getAccessToken(boolean forceRefresh) {
        if (!forceRefresh && wxaConfig.accessTokenNotExpired()) {
            return wxaConfig.getAccessToken();
        }

        Lock lock = wxaConfig.getAccessTokenLock();

        try {
            boolean isLocked;
            do {
                isLocked = lock.tryLock(LOCK_TIMEOUT_MS, TimeUnit.MICROSECONDS);
                if (!forceRefresh && wxaConfig.accessTokenNotExpired()) {
                    return wxaConfig.getAccessToken();
                }
            }while (!isLocked);
            WxTokenInfo wxTokenInfo = doGetAccessToken();
            wxaConfig.refreshAccessToken(wxTokenInfo);

            return wxTokenInfo.getAccessToken();
        } catch (InterruptedException e) {
            log.warn("[{}] accessToken lock interrupted error.", TAG, e);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

        return StringUtils.EMPTY;
    }

    @Override
    public WxaSessionInfoResponse code2Session(String jsCode) {
        String url = String.format(WxaUrlConstant.Login.CODE_2_SESSION,
                wxaConfig.getAppid(), wxaConfig.getSecret(), jsCode);

        String content = executeInternal(getDefaultGetExecutor(), url,
                null, getResponseHandler(), NO_RETRY, NO_RETRY);
        if (StringUtils.isNotBlank(content)) {
            return JacksonUtil.toBean(content, WxaSessionInfoResponse.class);
        }

        return null;
    }

    @Override
    public <T> T execute(WxRequestExecutor executor, String url,Object data, WxResponseHandler<T> responseHandler) {
        return execute(executor, url, data, responseHandler, true);
    }

    @Override
    public String getClientTag() {
        return TAG;
    }


    private <T> T execute(WxRequestExecutor executor, String url, Object data,
                          WxResponseHandler<T> responseHandler, boolean autoRefreshAccessToken) {
        String accessToken = getAccessToken(false);
        String urlWithAccessToken = urlConcatAccessToken(url, accessToken);

        try {
            return executeInternal(executor, urlWithAccessToken, data, responseHandler, 0, MAX_RETRY_COUNT);
        } catch (WxException ex) {
            // invalid accessToken
            if (WxError.isInvalidToken(ex.getCode())) {
                log.warn("[{}] access_token invalid, refresh access_token", TAG);
                Lock tokenLock = wxaConfig.getAccessTokenLock();
                tokenLock.lock();
                try {
                    if (accessToken.equals(wxaConfig.getAccessToken())) {
                        // 强制过期 accessToken, 下次请求时会自动刷新
                        wxaConfig.expiredAccessToken();
                    }
                } finally {
                    tokenLock.unlock();
                }

                if (autoRefreshAccessToken) {
                    return execute(executor, url, data, responseHandler, false);
                }
            }
            throw ex;
        }
    }

    private <T> T executeInternal(WxRequestExecutor executor, String url, Object data,
                                WxResponseHandler<T> responseHandler, int retryCount, int maxRetryCount)
            throws WxException{


        try {
            Response response = executor.execute(url, data);
            return responseHandler.handle(response);
        } catch (WxException | IOException ex) {
            WxException wxEp;
            if (ex instanceof IOException) {
                log.error("[{}] request io error.", TAG, ex);
                wxEp = new WxException(WxError.SERVER_ERROR);
            } else {
                wxEp = (WxException) ex;
            }

            if (NO_RETRY == maxRetryCount) {
                throw wxEp;
            }

            if ((++retryCount) > maxRetryCount) {
                log.error("[{}] retry max count [{}].",TAG, maxRetryCount);
                throw wxEp;
            }

            if (WxError.SERVER_ERROR.getCode().equals(wxEp.getCode())) {
                int sleepTime = 100 * (1 << retryCount);
                log.info("[{}] server or IO error, [{}] ms retry request", TAG, sleepTime);
                ThreadUtil.sleep(sleepTime);
                executeInternal(executor, url, data, responseHandler, retryCount, maxRetryCount);
            }
            throw wxEp;
        }
    }



    private String urlConcatAccessToken(String url, String accessToken) {
        String separator = url.contains(SymbolicConstant.QUESTION) ?
                SymbolicConstant.AMPLE : SymbolicConstant.QUESTION;

        return url + separator + WxConstant.ACCESS_TOKEN + SymbolicConstant.EQUAL + accessToken;
    }

    private WxTokenInfo doGetAccessToken() {
        WxAccessTokenRequest tokenRequest = new WxAccessTokenRequest()
                .setAppid(wxaConfig.getAppid())
                .setSecret(wxaConfig.getSecret())
                .setGrantType(WxGrantType.CLIENT_CREDENTIAL);

        String content = executeInternal(getDefaultPostExecutor(), WxaUrlConstant.STABLE_TOKEN,
                tokenRequest, getResponseHandler(), 1, MAX_RETRY_COUNT);
        if (StringUtils.isNotBlank(content)) {
            return JacksonUtil.toBean(content, WxTokenInfo.class);
        }
        throw new WxException(WxError.GET_ACCESS_TOKEN_ERROR);
    }
}
