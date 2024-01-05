package ink.honp.wx.miniapp.service;

import ink.honp.wx.core.entity.response.WxByteResponse;
import ink.honp.wx.miniapp.constant.WxaEnvVersion;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaQrcodeGetRequest;
import ink.honp.wx.miniapp.service.impl.WxaQrcodeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/05 16:19
 */
class WxaQrcodeServiceTest extends WxaServiceTest{

    @Test
    void testGetQrcode() {
        WxaQrcodeGetRequest qrcodeGetRequest = new WxaQrcodeGetRequest()
                .setPath("pages/index/index");
        qrcodeGetRequest.setWidth(520);
        qrcodeGetRequest.setHyaline(true);
        qrcodeGetRequest.setEnvVersion(WxaEnvVersion.DEVELOP);


        WxaQrcodeService qrcodeService = new WxaQrcodeServiceImpl(getWxaClient());
        WxByteResponse byteResponse = qrcodeService.getQrcode(qrcodeGetRequest);

        Assertions.assertNotNull(byteResponse);

    }
}
