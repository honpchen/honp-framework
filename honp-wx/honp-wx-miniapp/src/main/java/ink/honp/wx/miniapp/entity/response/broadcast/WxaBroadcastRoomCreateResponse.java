package ink.honp.wx.miniapp.entity.response.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 10:23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomCreateResponse extends WxResponse {

    /**
     * 房间ID
     */
    private Long roomId;

    /**
     * "小程序直播" 小程序码
     * 当主播微信号没有在 “小程序直播“ 小程序实名认证 返回该字段
     */
    @JsonProperty("qrcode_url")
    private String qrcodeUrl;
}
