package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleDeleteRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleQueryRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastRoleListResponse;
import ink.honp.wx.miniapp.service.WxaBroadcastRoleService;

/**
 * @author jeffchen
 * date    2024/01/08 16:48
 */
public class WxaBroadcastRoleServiceImpl implements WxaBroadcastRoleService {

    private final WxaClient wxaClient;

    public WxaBroadcastRoleServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public String addRole(WxaBroadcastRoleRequest roleAddRequest) {

        String response =  wxaClient.post(WxaUrlConstant.BroadcastRole.ADD, roleAddRequest);

        return WxResponseParseUtil.parse(response, "codeurl");
    }

    @Override
    public void deleteRole(WxaBroadcastRoleDeleteRequest roleDeleteRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRole.DELETE, roleDeleteRequest);
    }

    @Override
    public WxaBroadcastRoleListResponse getRoleList(WxaBroadcastRoleQueryRequest roleQueryRequest) {

        return wxaClient.get(WxaUrlConstant.BroadcastRole.GET_LIST, roleQueryRequest, WxaBroadcastRoleListResponse.class);
    }
}
