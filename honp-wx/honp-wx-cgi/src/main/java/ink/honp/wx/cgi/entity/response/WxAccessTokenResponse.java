package ink.honp.wx.cgi.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/02 11:17
 */
@Data
public class WxAccessTokenResponse {

    /** 凭证 **/
    @JsonProperty("access_token")
    private String accessToken;

    /** 凭证过期时间,秒 **/
    @JsonProperty("expires_in")
    private Integer expiresIn;
}
