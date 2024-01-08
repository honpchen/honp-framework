package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.msg.WxaMessageActivityIdCreateRequest;
import ink.honp.wx.miniapp.entity.response.msg.WxaMessageActivityIdResponse;
import ink.honp.wx.miniapp.service.impl.WxaActivityMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/08 10:11
 */
@Slf4j
class WxaActivityMessageServiceTest extends WxaServiceTest{
    
    @Test
    void testCreate() {
       WxaActivityMessageService wxaActivityMessageService = new WxaActivityMessageServiceImpl(getWxaClient());

        WxaMessageActivityIdCreateRequest activityIdCreateRequest = new WxaMessageActivityIdCreateRequest()
                .setOpenid("oxMZd5XQ9FCS2aBdhKTIfh9D5gJU");
        WxaMessageActivityIdResponse response = wxaActivityMessageService.createActivityId(activityIdCreateRequest);

        Assertions.assertNotNull(response);
    }
}
