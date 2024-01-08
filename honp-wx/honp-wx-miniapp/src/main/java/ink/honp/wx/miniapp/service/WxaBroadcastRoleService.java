package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleDeleteRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastRoleQueryRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastRoleListResponse;

/**
 * @author jeffchen
 * date    2024/01/05 14:31
 */
public interface WxaBroadcastRoleService extends WxaService {

    /**
     * 设置成员角色
     * @param roleAddRequest -
     * @return codeurl, 如果主播未实名认证，需要先前往“小程序直播”小程序进行实名验证
     */
    String addRole(WxaBroadcastRoleRequest roleAddRequest);

    /**
     * 删除成员角色
     * @param roleDeleteRequest -
     */
    void deleteRole(WxaBroadcastRoleDeleteRequest roleDeleteRequest);

    /**
     * 获取成员角色列表
     * @param roleQueryRequest -
     * @return -
     */
    WxaBroadcastRoleListResponse getRoleList(WxaBroadcastRoleQueryRequest roleQueryRequest);
}
