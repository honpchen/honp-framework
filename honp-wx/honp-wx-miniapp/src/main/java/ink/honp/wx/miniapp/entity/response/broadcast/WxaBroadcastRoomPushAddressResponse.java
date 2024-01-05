package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 10:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomPushAddressResponse extends WxResponse {

    /**
     * 推流地址
     */
    private String pushAddr;
}
