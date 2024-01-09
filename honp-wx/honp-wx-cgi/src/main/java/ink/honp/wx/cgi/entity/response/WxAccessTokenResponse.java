package ink.honp.wx.cgi.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/02 11:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxAccessTokenResponse extends WxResponse {

    /** 凭证 **/
    @JsonProperty("access_token")
    private String accessToken;

    /** 凭证过期时间,秒 **/
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
