package ink.honp.wx.core.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 10:06
 */
@Data
@Accessors(chain = true)
public class WxAccessTokenRequest implements WxRequest {

    private String appid;

    private String secret;

    @JsonProperty("grant_type")
    private String grantType;
}
