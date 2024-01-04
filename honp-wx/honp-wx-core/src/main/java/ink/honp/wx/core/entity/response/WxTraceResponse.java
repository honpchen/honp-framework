package ink.honp.wx.core.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 17:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxTraceResponse extends WxResponse {

    /**
     * 唯一请求标识，标记单次请求
     */
    @JsonProperty("trace_id")
    private String traceId;
}
