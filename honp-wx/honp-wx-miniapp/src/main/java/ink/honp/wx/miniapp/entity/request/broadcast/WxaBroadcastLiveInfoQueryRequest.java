package ink.honp.wx.miniapp.entity.request.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 10:09
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastLiveInfoQueryRequest implements WxRequest {

    /**
     * 起始拉取视频，0表示从第一个视频片段开始拉取
     * 必填
     */
    private Integer start;

    /**
     * 每次拉取的数量，建议100以内
     * 必填
     */
    private Integer limit;

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
