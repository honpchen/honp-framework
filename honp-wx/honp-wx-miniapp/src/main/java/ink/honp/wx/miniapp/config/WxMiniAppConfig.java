package ink.honp.wx.miniapp.config;

import okhttp3.OkHttpClient;

/**
 * 微信小程序配置接口
 * @author jeff chen
 * @since 2024-01-01 16:53
 */
public interface WxMiniAppConfig {

    String getAppid();

    String getSecret();

    /**
     * 接口调用凭证
     * @return access_token
     */
    String getAccessToken();
}
