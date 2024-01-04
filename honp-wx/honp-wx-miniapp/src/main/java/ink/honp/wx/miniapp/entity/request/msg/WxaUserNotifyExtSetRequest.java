package ink.honp.wx.miniapp.entity.request.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 16:31
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaUserNotifyExtSetRequest extends WxaUserNotifyRequest {

    /**
     * 扩展信息，不同卡片的定义不同
     */
    @JsonProperty("ext_json")
    private String extJson;
}
