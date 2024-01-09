package ink.honp.wx.oa.entity.request.oauth;

import ink.honp.wx.cgi.entity.request.WxAccessTokenRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/09 17:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxoaOauth2AccessTokenRequest extends WxAccessTokenRequest {

    /**
     * 网页授权 code，必填
     */
    private String code;
}
