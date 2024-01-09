package ink.honp.wx.oa.entity.response.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.cgi.entity.response.WxAccessTokenResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/09 16:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxoaOauth2AccessTokenResponse extends WxAccessTokenResponse {

    /**
     * 用户刷新 access_token
     */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     */
    @JsonProperty("openid")
    private String openid;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    @JsonProperty("scope")
    private String scope;

    /**
     * 用户统一标识（针对一个微信开放平台账号下的应用，同一用户的 unionid 是唯一的），
     * 只有当scope为"snsapi_userinfo"时返回
     */
    @JsonProperty("unionid")
    private String unionid;

    /**
     * 是否为快照页模式虚拟账号，只有当用户是快照页模式虚拟账号时返回，值为1
     */
    @JsonProperty("is_snapshotuser")
    private Integer isSnapshotuser;
}
