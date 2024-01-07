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
public class WxaNfcSchemeGenerateRequest extends WxaUrlSchemeRequest {

    /**
     * scheme对应的设备model_id，必填
     */
    @JsonProperty("model_id")
    private String modelId;

    /**
     * scheme对应的设备sn，仅一机一码时填写
     */
    private String sn;
}
