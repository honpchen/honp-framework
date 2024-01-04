package ink.honp.wx.miniapp.entity.response.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 14:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaMessageActivityIdResponse extends WxResponse {

    /**
     * 动态消息的 ID
     */
    @JsonProperty("activity_id")
    private String activityId;

    /**
     * activity_id 的过期时间戳。默认24小时后过期
     */
    @JsonProperty("expiration_time")
    private Long expirationTime;
}
