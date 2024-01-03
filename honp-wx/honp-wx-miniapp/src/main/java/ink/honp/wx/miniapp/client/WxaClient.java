package ink.honp.wx.miniapp.client;

import ink.honp.wx.core.client.WxClient;
import ink.honp.wx.miniapp.config.WxaConfig;

/**
 * 微信小程序端
 * @author jeff chen
 * @since 2024-01-01 17:41
 */
public interface WxaClient extends WxClient {

    /**
     * 获取小程序配置
     * @return 小程序配置
     */
    WxaConfig getConfig();

    /**
     * 获取 access_token
     * @param forceRefresh 是否强制刷新
     * @return access_token
     */
    String getAccessToken(boolean forceRefresh);
}
