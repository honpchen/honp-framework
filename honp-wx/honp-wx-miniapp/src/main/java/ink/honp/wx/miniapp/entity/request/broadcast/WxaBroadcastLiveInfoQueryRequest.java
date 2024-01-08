package ink.honp.wx.miniapp.entity.request.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxPageRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 10:09
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastLiveInfoQueryRequest extends WxPageRequest {

    /**
     * 只能填"get_replay"，表示获取回放
     */
    private String action;

    /**
     * 当action有值时该字段必填，直播间ID
     */
    @JsonProperty("room_id")
    private Long roomId;

}
