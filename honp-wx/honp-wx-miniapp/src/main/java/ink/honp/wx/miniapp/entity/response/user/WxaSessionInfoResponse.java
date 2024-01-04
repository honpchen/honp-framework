package ink.honp.wx.miniapp.entity.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/03 17:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaSessionInfoResponse extends WxResponse {

    /** 会话密钥 **/
    @JsonProperty("session_key")
    private String sessionKey;

    /** 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回 **/
    private String unionid;

    /** 用户唯一标识 **/
    private String openid;
}
