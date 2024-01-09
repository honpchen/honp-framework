package ink.honp.wx.cgi.config;

import ink.honp.core.http.enums.HttpLogLevel;

import java.util.concurrent.locks.Lock;

/**
 * @author jeffchen
 * date    2024/01/09 11:30
 */
public interface WxClientConfig {

    String getClientTag();

    String getAccessToken();

    Lock getAccessTokenLock();

    /**
     * accessToken 是否过期
     * @return {@code true} 未过期
     */
    boolean accessTokenNotExpired();

    /**
     * 刷新 accessToken
     * @param accessToken accessToken
     * @param expiresIn accessToken存活时间，秒
     */
    void refreshAccessToken(String accessToken, Integer expiresIn);

    /**
     * 强制 accessToken 过期
     */
    void expiredAccessToken();

    Integer getTimeout();

    HttpLogLevel getLevel();
}
