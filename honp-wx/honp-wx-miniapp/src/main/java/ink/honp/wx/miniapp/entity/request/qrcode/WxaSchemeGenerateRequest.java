package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 9:51
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaSchemeGenerateRequest extends WxaUrlSchemeRequest {

    /**
     * 到期失效的 scheme 码的失效时间，为 Unix 时间戳。生成的到期失效 scheme 码在该时间前有效。
     * 最长有效期为30天。is_expire 为 true 且 expire_type 为 0 时必填
     */
    @JsonProperty("expire_time")
    private Long expireTime;

    /**
     * 默认值0，到期失效的 scheme 码失效类型，失效时间：0，失效间隔天数：1
     */
    @JsonProperty("expire_type")
    private Integer expireType;

    /**
     * 到期失效的 scheme 码的失效间隔天数。生成的到期失效 scheme 码在该间隔时间到达前有效。
     * 最长间隔天数为30天。is_expire 为 true 且 expire_type 为 1 时必填
     */
    @JsonProperty("expire_interval")
    private Integer expireInterval;
}
