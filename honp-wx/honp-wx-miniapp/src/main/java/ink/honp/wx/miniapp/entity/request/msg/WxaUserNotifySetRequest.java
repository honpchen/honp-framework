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
public class WxaUserNotifySetRequest extends WxaUserNotifyRequest {

    /**
     * 卡片状态与状态相关字段，不同卡片的定义不同。
     */
    @JsonProperty("content_json")
    private String contentJson;

    /**
     * 微信支付订单号验证字段， 当将微信支付订单号作为 notify_code 时，在激活时需要传入
     */
    @JsonProperty("check_json")
    private String checkJson;
}
