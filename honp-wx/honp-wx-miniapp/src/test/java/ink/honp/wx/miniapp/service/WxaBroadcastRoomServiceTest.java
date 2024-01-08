package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastLiveInfoQueryRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastAssistantListResponse;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastLiveListResponse;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastRoomPushAddressResponse;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastRoomShareCodeResponse;
import ink.honp.wx.miniapp.service.impl.WxaBroadcastRoomServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/08 15:12
 */
@Slf4j
class WxaBroadcastRoomServiceTest extends WxaServiceTest {

    @Test
    void testGetLiveInfo() {
        WxaBroadcastRoomService wxaBroadcastRoomService = new WxaBroadcastRoomServiceImpl(getWxaClient());

        WxaBroadcastLiveInfoQueryRequest queryRequest = new WxaBroadcastLiveInfoQueryRequest();
        queryRequest.setStart(0);
        queryRequest.setLimit(10);
        queryRequest.setAction("get_replay");
        queryRequest.setRoomId(14L);

        WxaBroadcastLiveListResponse liveInfo = wxaBroadcastRoomService.getLiveInfo(queryRequest);
        Assertions.assertNotNull(liveInfo);

        log.info("liveInfo:{}", JacksonUtil.toJson(liveInfo));
    }
    
    @Test
    void testGetPushUrl() {
        WxaBroadcastRoomService wxaBroadcastRoomService = new WxaBroadcastRoomServiceImpl(getWxaClient());

        String pushUrl = wxaBroadcastRoomService.getPushUrl(14L);
        Assertions.assertNotNull(pushUrl);

        log.info("pushUrl:{}", pushUrl);
    }

    @Test
    void testGetShareCode() {
        WxaBroadcastRoomService wxaBroadcastRoomService = new WxaBroadcastRoomServiceImpl(getWxaClient());

        WxaBroadcastRoomShareCodeResponse shareCode = wxaBroadcastRoomService.getShareCode(14L, null);
        Assertions.assertNotNull(shareCode);

        log.info("shareCode:{}", JacksonUtil.toJson(shareCode));
    }

    @Test
    void testGetSubAnchor() {
        WxaBroadcastRoomService wxaBroadcastRoomService = new WxaBroadcastRoomServiceImpl(getWxaClient());
        String subAnchor = wxaBroadcastRoomService.getSubAnchor(14L);

        Assertions.assertNotNull(subAnchor);
        log.info("subAnchor:{}", subAnchor);
    }

    @Test
    void testGetAssistantList() {
        WxaBroadcastRoomService wxaBroadcastRoomService = new WxaBroadcastRoomServiceImpl(getWxaClient());

        WxaBroadcastAssistantListResponse assistantList = wxaBroadcastRoomService.getAssistantList(14L);
        Assertions.assertNotNull(assistantList);
        log.info("assistantList:{}", JacksonUtil.toJson(assistantList));
    }
}
