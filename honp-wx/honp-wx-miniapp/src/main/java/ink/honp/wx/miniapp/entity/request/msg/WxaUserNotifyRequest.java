package ink.honp.wx.miniapp.entity.request.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/04 16:49
 */
@Data
public class WxaUserNotifyRequest implements WxRequest {

    /**
     * 用户身份标识符, 必填
     */
    private String openid;

    /**
     * 动态更新令牌，必填
     */
    @JsonProperty("notify_code")
    private String notifyCode;

    /**
     * 卡片id，必填
     */
    @JsonProperty("notify_type")
    private Integer notifyType;
}
