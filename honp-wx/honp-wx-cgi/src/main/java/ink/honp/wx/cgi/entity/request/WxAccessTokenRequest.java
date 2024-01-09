package ink.honp.wx.cgi.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/09 17:01
 */
@Data
@Accessors(chain = true)
public class WxAccessTokenRequest implements WxRequest {

    private String appid;

    private String secret;

    @JsonProperty("grant_type")
    private String grantType;
}
