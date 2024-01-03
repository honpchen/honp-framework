package ink.honp.wx.miniapp.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.constant.WxGrantType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/02 11:38
 */
@Data
@Accessors(chain = true)
public class WxaAccessTokenRequest {

    private String appid;

    private String secret;

    @JsonProperty("grant_type")
    private String grantType = WxGrantType.CLIENT_CREDENTIAL;
}
