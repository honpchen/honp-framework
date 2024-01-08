package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleQueryRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastRoleListResponse;
import ink.honp.wx.miniapp.service.impl.WxaBroadcastRoleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/08 16:56
 */
@Slf4j
class WxaBroadcastRoleServiceTest extends WxaServiceTest{
    
    @Test
    void testGetList() {
        WxaBroadcastRoleService wxaBroadcastRoleService = new WxaBroadcastRoleServiceImpl(getWxaClient());

        WxaBroadcastRoleQueryRequest queryRequest = new WxaBroadcastRoleQueryRequest()
                .setOffset(0)
                .setLimit(10)
                .setRole(-1);

        WxaBroadcastRoleListResponse roleList = wxaBroadcastRoleService.getRoleList(queryRequest);

        Assertions.assertNotNull(roleList);

        log.info("roleList: {}", JacksonUtil.toJson(roleList));
    }
}
