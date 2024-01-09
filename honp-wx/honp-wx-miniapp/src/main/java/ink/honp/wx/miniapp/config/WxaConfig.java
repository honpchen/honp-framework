package ink.honp.wx.miniapp.config;

import ink.honp.wx.cgi.config.WxClientConfig;

/**
 * 微信小程序配置接口
 * @author jeff chen
 * @since 2024-01-01 16:53
 */
public interface WxaConfig extends WxClientConfig {

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
}
