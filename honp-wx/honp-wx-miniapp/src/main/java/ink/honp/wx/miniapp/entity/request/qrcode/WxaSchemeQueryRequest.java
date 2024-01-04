package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 10:28
 */
@Data
@Accessors(chain = true)
public class WxaSchemeQueryRequest implements WxRequest {

    /**
     * 小程序 scheme 码。支持加密 scheme 和明文 scheme
     */
    private String scheme;

    /**
     * 查询类型。默认值0，查询 scheme 码信息：0， 查询每天剩余访问次数：1
     */
    @JsonProperty("query_type")
    private Integer queryType;
}
