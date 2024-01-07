package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.qrcode.WxaSchemeGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaSchemeQueryRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlSchemeRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaSchemeInfoResponse;
import ink.honp.wx.miniapp.service.impl.WxaUrlSchemeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeff chen
 * @since 2024-01-07 22:09
 */
@Slf4j
class WxaUrlSchemeServiceTest extends WxaServiceTest{

    @Test
    void testQuery() {
        WxaUrlSchemeService wxaUrlSchemeService = new WxaUrlSchemeServiceImpl(getWxaClient());

        WxaSchemeInfoResponse response = wxaUrlSchemeService.queryScheme(new WxaSchemeQueryRequest());

        Assertions.assertNotNull(response);

        log.info("WxaScheme query response:{}", response);
    }

    @Test
    void testGenerateScheme() {
        WxaUrlSchemeService wxaUrlSchemeService = new WxaUrlSchemeServiceImpl(getWxaClient());

        WxaSchemeGenerateRequest generateRequest = new WxaSchemeGenerateRequest()
                .setExpireType(1)
                .setExpireInterval(1);


        WxaUrlSchemeRequest.JumpWxa jumpWxa = new WxaUrlSchemeRequest.JumpWxa()
                .setPath("pages/index/index")
                .setEnvVersion("develop");
        generateRequest.setJumpWxa(jumpWxa);

        String scheme = wxaUrlSchemeService.generateScheme(generateRequest);

        log.info("GenerateScheme:{}", scheme);

    }
}
