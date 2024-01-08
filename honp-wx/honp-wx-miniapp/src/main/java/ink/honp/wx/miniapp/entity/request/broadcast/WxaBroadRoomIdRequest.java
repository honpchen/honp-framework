package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/08 15:45
 */
@Data
public class WxaBroadRoomIdRequest implements WxRequest {

    /**
     * 房间ID
     */
    private Long roomId;
}
