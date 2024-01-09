package ink.honp.wx.miniapp.client;

import ink.honp.wx.cgi.client.WxCgiClient;
import ink.honp.wx.core.client.WxClient;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.entity.response.user.WxaSessionInfoResponse;
import ink.honp.wx.miniapp.service.WxaService;

/**
 * 微信小程序端
 * @author jeff chen
 * @since 2024-01-01 17:41
 */
public interface WxaClient extends WxCgiClient {

    /**
     * 获取小程序配置
     * @return 小程序配置
     */
    WxaConfig getConfig();

    /**
     * 登录凭证校验
     * @param jsCode jsCode 登录时获取的 code，可通过wx.login获取
     * @return WxaSessionInfoResponse
     */
    WxaSessionInfoResponse code2Session(String jsCode);

    /**
     * 获取小程序服务
     * @param clazz 小程序服务类型
     * @return 服务实例
     * @param <T> -
     */
    <T extends WxaService> T getWxaService(Class<T> clazz);
}
