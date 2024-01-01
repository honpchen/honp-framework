package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import ink.honp.wx.core.service.impl.WxAbstractServiceImpl;
import ink.honp.wx.miniapp.config.WxMiniAppConfig;
import ink.honp.wx.miniapp.service.WxMiniAppService;

import java.util.List;

/**
 * @author jeff chen
 * @since 2024-01-01 17:45
 */
public class WxMiniAppServiceImpl extends WxAbstractServiceImpl implements WxMiniAppService {

    private final WxMiniAppConfig wxMiniAppConfig;

    public WxMiniAppServiceImpl(WxMiniAppConfig wxMiniAppConfig) {
        this.wxMiniAppConfig = wxMiniAppConfig;
    }

    @Override
    public WxMiniAppConfig getConfig() {
        return this.wxMiniAppConfig;
    }

    @Override
    public String get(String url, Object queryParams) {
        return null;
    }

    @Override
    public <T> T get(String url, Object queryParams, Class<T> repClz) {
        return null;
    }

    @Override
    public <T> List<T> getList(String url, Object queryParams, Class<T> repClz) {
        return null;
    }

    @Override
    public String post(String url, Object data) {
        return null;
    }

    @Override
    public <T> T post(String url, Object data, Class<T> repClz) {
        return null;
    }

    @Override
    public <E, R> R execute(WxRequestExecutor<E, R> executor, String url, E data, WxResponseHandler<R> responseHandler) {
        return null;
    }
}
