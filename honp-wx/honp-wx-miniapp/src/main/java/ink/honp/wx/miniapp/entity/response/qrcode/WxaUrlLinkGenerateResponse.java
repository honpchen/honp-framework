package ink.honp.wx.miniapp.entity.response.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 11:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaUrlLinkGenerateResponse extends WxResponse {

    /**
     * 生成的小程序 URL Link
     */
    @JsonProperty("url_link")
    private String urlLink;
}

