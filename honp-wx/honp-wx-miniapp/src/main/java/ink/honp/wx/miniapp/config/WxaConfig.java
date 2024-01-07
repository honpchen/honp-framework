package ink.honp.wx.miniapp.config;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.wx.core.entity.WxTokenInfo;

import java.util.concurrent.locks.Lock;

/**
 * 微信小程序配置接口
 * @author jeff chen
 * @since 2024-01-01 16:53
 */
public interface WxaConfig {

    /**
     * appid
     */
    String getAppid();

    /**
     * secret
     */
    String getSecret();

    /**
     * 消息服务配置 token
     * @return 服务配置 token
     */
    String getToken();

    /**
     * 消息加密密钥
     * @return 消息加密密钥
     */
    String getEncodingAesKey();

    /**
     * 接口调用凭证
     * @return access_token
     */
    String getAccessToken();

    /**
     * accessToken 是否过期
     * @return {@code true} 未过期
     */
    boolean accessTokenNotExpired();

    /**
     * access_token 锁，防止并发刷新
     * @return lock
     */
    Lock getAccessTokenLock();

    /**
     * 刷新 accessToken
     * @param tokenInfo -
     */
    void refreshAccessToken(WxTokenInfo tokenInfo);

    /**
     * 强制 accessToken 过期
     */
    void expiredAccessToken();

    /**
     * 请求超时时间
     * @return 秒
     */
    Integer getTimeout();

    /**
     * 日志级别
     * <pre>
     *     none - 无，
     *     basic - url,
     *     body - request body
     * </pre>
     * @return 日志级别
     */
    HttpLogLevel getLevel();
}
