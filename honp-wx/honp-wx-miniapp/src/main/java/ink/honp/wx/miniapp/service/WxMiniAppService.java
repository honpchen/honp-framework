package ink.honp.wx.miniapp.service;

import ink.honp.core.http.response.ResponseHandler;
import ink.honp.wx.core.service.WxService;
import ink.honp.wx.miniapp.config.WxMiniAppConfig;
import okhttp3.Request;

/**
 * @author jeff chen
 * @since 2024-01-01 17:41
 */
public interface WxMiniAppService extends WxService {

    /**
     * 获取小程序配置
     * @return 小程序配置
     */
    WxMiniAppConfig getConfig();
}
