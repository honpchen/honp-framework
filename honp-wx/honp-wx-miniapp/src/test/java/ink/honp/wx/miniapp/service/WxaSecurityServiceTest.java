package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.request.sec.WxaUserRiskRankGetRequest;
import ink.honp.wx.miniapp.entity.response.sec.WxaUserRiskRankResponse;
import ink.honp.wx.miniapp.service.impl.WxaSecurityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/08 13:54
 */
@Slf4j
class WxaSecurityServiceTest extends WxaServiceTest {

    @Test
    void testGetUserRiskRank() {
        WxaUserRiskRankGetRequest userRiskRankGetRequest = new WxaUserRiskRankGetRequest()
                .setAppid("wx53b2b2472696934b")
                .setOpenid("oxMZd5QIXaS2nFM-vVRYsVXIFzkY")
                .setScene(1)
                .setClientIp("59.41.200.90");

        WxaSecurityService wxaSecurityService = new WxaSecurityServiceImpl(getWxaClient());
        WxaUserRiskRankResponse userRiskRankResponse = wxaSecurityService.getUserRiskRank(userRiskRankGetRequest);
        System.out.println(userRiskRankResponse);

        Assertions.assertNotNull(userRiskRankResponse);
        log.info("userRiskRankResponse:{}", JacksonUtil.toJson(userRiskRankResponse));

    }
}
