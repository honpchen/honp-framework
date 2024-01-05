package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 14:32
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastRoleAddRequest implements WxRequest {

    /**
     * 用户的微信号
     */
    private String username;

    /**
     * 设置用户的角色
     * 取值[1-管理员，2-主播，3-运营者]，设置超级管理员将无效
     */
    private Long role;
}
