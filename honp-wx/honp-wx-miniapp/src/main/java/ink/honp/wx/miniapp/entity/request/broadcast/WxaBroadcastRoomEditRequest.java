package ink.honp.wx.miniapp.entity.request.broadcast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 10:09
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomEditRequest extends WxaBroadcastRoomCreateRequest {

    /**
     * 直播间id
     * 必填
     */
    private Long id;

}
