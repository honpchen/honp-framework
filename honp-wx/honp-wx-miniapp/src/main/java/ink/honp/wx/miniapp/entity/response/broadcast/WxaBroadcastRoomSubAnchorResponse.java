package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 11:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomSubAnchorResponse extends WxResponse {

    /**
     * 主播副号
     */
    private String username;
}
