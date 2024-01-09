package ink.honp.wx.oa.factory;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.oa.client.WxoaClient;
import ink.honp.wx.oa.service.WxoaKfService;
import ink.honp.wx.oa.service.WxoaService;
import ink.honp.wx.oa.service.impl.WxoaKfServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2024/01/08 18:22
 */
@Slf4j
public class WxoaServiceFactory {

    private final Map<String, WxoaService> wxoaServiceMap = CollectionUtil.newHashMap(16);

    public WxoaServiceFactory(WxoaClient wxoaClient) {
        init(wxoaClient);
    }

    @SuppressWarnings("unchecked")
    public <T extends WxoaService> T getWxaService(Class<T> clazz) {
        WxoaService wxoaService = wxoaServiceMap.get(clazz.getName());
        if (Objects.isNull(wxoaService)) {
            log.error("Not found wxoaService [{}]", clazz.getName());
        }
        return (T) wxoaService;
    }

    private void init(WxoaClient wxoaClient) {
        wxoaServiceMap.put(WxoaKfService.class.getName(), new WxoaKfServiceImpl(wxoaClient));
    }
}
