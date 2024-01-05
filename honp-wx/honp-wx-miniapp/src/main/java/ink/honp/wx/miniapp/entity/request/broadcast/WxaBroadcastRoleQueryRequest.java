package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 14:37
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastRoleQueryRequest implements WxRequest {

    /**
     * 查询的用户角色，取值 [-1-所有成员， 0-超级管理员，1-管理员，2-主播，3-运营者]，默认-1
     */
    private Long role;

    /**
     * 起始偏移量, 默认0
     */
    private Integer offset;

    /**
     * 查询个数，最大30，默认10
     */
    private Integer limit;

    /**
     * 搜索的微信号或昵称，不传则返回全部
     */
    private String keyword;
}
