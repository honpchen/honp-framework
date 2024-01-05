package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 11:18
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastRoomSubAnchorRequest implements WxRequest {

    /**
     * 房间ID, 必填
     */
    private Long roomId;

    /**
     * 微信号，必填
     */
    private String username;
}
