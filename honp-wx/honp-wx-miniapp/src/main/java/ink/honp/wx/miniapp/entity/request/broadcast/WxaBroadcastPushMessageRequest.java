package ink.honp.wx.miniapp.entity.request.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 14:46
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastPushMessageRequest implements WxRequest {

    /**
     * 直播开始事件的房间ID
     */
    private Long roomId;

    /**
     * 接收该群发开播事件的订阅用户OpenId列表
     */
    @JsonProperty("user_openid")
    private List<String> userOpenid;
}
