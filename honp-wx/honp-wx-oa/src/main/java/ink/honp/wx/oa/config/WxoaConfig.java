package ink.honp.wx.oa.config;

import ink.honp.wx.cgi.config.WxClientConfig;

/**
 * @author jeffchen
 * date    2024/01/09 14:45
 */
public interface WxoaConfig extends WxClientConfig {

    /**
     * 账号唯一凭证，即 AppID，可在「微信公众平台 - 设置 - 开发设置」页中获得
     */
    String getAppid();

    /**
     * 账号唯一凭证密钥，即 AppSecret，获取方式同 appid
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
