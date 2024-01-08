package ink.honp.wx.miniapp.factory;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.service.*;
import ink.honp.wx.miniapp.service.impl.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2024/01/08 18:22
 */
@Slf4j
public class WxaServiceFactory {

    private final Map<String, WxaService> wxaServiceMap = CollectionUtil.newHashMap(16);

    public WxaServiceFactory(WxaClient wxaClient) {
        init(wxaClient);
    }

    @SuppressWarnings("unchecked")
    public <T extends WxaService> T getWxaService(Class<T> clazz) {
        WxaService wxaService = wxaServiceMap.get(clazz.getName());
        if (Objects.isNull(wxaService)) {
            log.error("Not found wxaService [{}]", clazz.getName());
        }
        return (T) wxaService;
    }

    private void init(WxaClient wxaClient) {
        wxaServiceMap.put(WxaUserService.class.getName(), new WxaUserServiceImpl(wxaClient));
        wxaServiceMap.put(WxaQrcodeService.class.getName(), new WxaQrcodeServiceImpl(wxaClient));
        wxaServiceMap.put(WxaUrlSchemeService.class.getName(), new WxaUrlSchemeServiceImpl(wxaClient));
        wxaServiceMap.put(WxaUrlLinkService.class.getName(), new WxaUrlLinkServiceImpl(wxaClient));
        wxaServiceMap.put(WxaActivityMessageService.class.getName(), new WxaActivityMessageServiceImpl(wxaClient));
        wxaServiceMap.put(WxaSubscribeMessageService.class.getName(), new WxaSubscribeMessageServiceImpl(wxaClient));
        wxaServiceMap.put(WxaSecurityService.class.getName(), new WxaSecurityServiceImpl(wxaClient));
        wxaServiceMap.put(WxaAnalysisService.class.getName(), new WxaAnalysisServiceImpl(wxaClient));
        wxaServiceMap.put(WxaBroadcastRoomService.class.getName(), new WxaBroadcastRoomServiceImpl(wxaClient));
        wxaServiceMap.put(WxaBroadcastGoodsService.class.getName(), new WxaBroadcastGoodsServiceImpl(wxaClient));
        wxaServiceMap.put(WxaBroadcastRoleService.class.getName(), new WxaBroadcastRoleServiceImpl(wxaClient));
        wxaServiceMap.put(WxaBroadcastMessageService.class.getName(), new WxaBroadcastMessageServiceImpl(wxaClient));
        wxaServiceMap.put(WxaRedPacketService.class.getName(), new WxaRedPacketServiceImpl(wxaClient));
    }
}
