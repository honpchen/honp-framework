package ink.honp.wx.oa.client;

import ink.honp.wx.cgi.client.WxCgiClient;
import ink.honp.wx.oa.config.WxoaConfig;
import ink.honp.wx.oa.service.WxoaService;

/**
 * @author jeffchen
 * date    2024/01/09 14:47
 */
public interface WxoaClient extends WxCgiClient {

    /**
     * 获取小程序配置
     * @return 小程序配置
     */
    WxoaConfig getConfig();

    /**
     * 获取公众号服务 API
     * @param clazz 公众号服务 API 类型
     * @return 服务实例
     * @param <T> -
     */
    <T extends WxoaService> T getWxoaService(Class<T> clazz);
}
