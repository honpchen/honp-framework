package ink.honp.wx.oa.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.oa.entity.response.kf.WxoaKfListResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/09 16:31
 */
@Slf4j
class WxoaKfServiceTest extends WxoaServiceTest{
    
    @Test
    void testList() {
        WxoaKfService wxoaService = getWxoaClient().getWxoaService(WxoaKfService.class);

        WxoaKfListResponse response = wxoaService.list();
        Assertions.assertNotNull(response);

        log.info("Kf account list:{}", JacksonUtil.toJson(response));
    }
}
