package ink.honp.wx.miniapp.entity.request.broadcast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 11:18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomSubAnchorRequest extends WxaBroadRoomIdRequest {

    /**
     * 微信号，必填
     */
    private String username;
}
