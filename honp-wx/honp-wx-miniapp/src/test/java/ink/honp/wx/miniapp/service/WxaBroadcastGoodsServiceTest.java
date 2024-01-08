package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastGoodsAuditInfoResponse;
import ink.honp.wx.miniapp.service.impl.WxaBroadcastGoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author jeffchen
 * date    2024/01/08 16:41
 */
@Slf4j
class WxaBroadcastGoodsServiceTest extends WxaServiceTest{

    @Test
    void testGetGoodsAuditInfo() {
        WxaBroadcastGoodsService wxaBroadcastGoodsService = new WxaBroadcastGoodsServiceImpl(getWxaClient());

        WxaBroadcastGoodsAuditInfoResponse goodsAuditInfo = wxaBroadcastGoodsService.getGoodsAuditInfo(Arrays.asList(16L, 17L));

        Assertions.assertNotNull(goodsAuditInfo);

        log.info("BroadGoods:{}", JacksonUtil.toJson(goodsAuditInfo));
    }
}
