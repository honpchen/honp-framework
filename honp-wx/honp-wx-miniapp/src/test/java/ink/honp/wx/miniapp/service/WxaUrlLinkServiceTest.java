package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.constant.WxaEnvVersion;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkQueryRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaUrlLinkResponse;
import ink.honp.wx.miniapp.service.impl.WxaUrlLinkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeff chen
 * @since 2024-01-07 22:34
 */
@Slf4j
class WxaUrlLinkServiceTest extends WxaServiceTest{

    @Test
    void testGenerateUrlLink() {
        WxaUrlLinkService urlLinkService = new WxaUrlLinkServiceImpl(getWxaClient());

        WxaUrlLinkGenerateRequest generateRequest = new WxaUrlLinkGenerateRequest()
                .setPath("pages/index/index")
                .setEnvVersion(WxaEnvVersion.DEVELOP);

        String urlLink = urlLinkService.generateUrlLink(generateRequest);
        Assertions.assertNotNull(urlLink);

        log.info("URL Link:{}", urlLink);
    }

    @Test
    void testQueryWithQueryType_1() {
        WxaUrlLinkService urlLinkService = new WxaUrlLinkServiceImpl(getWxaClient());

        WxaUrlLinkQueryRequest queryRequest = new WxaUrlLinkQueryRequest()
//                .setUrlLink("https://wxaurl.cn/3TjDahot2Et")
                .setQueryType(1);

        WxaUrlLinkResponse wxaUrlLinkResponse = urlLinkService.queryUrlLink(queryRequest);
        Assertions.assertNotNull(wxaUrlLinkResponse);

        log.info("URL Link query response:{}", JacksonUtil.toJson(wxaUrlLinkResponse));
    }
}
