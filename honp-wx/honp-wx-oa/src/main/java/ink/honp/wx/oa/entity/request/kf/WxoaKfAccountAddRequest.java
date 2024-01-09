package ink.honp.wx.oa.entity.request.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/09 16:02
 */
@Data
@Accessors(chain = true)
public class WxoaKfAccountAddRequest implements WxRequest {

    /**
     * 完整客服账号，格式为：账号前缀@公众号微信号，必填
     */
    @JsonProperty("kf_account")
    private String kfAccount;

    /**
     * 客服昵称，最长6个汉字或12个英文字符,必填
     */
    private String nickname;

    /**
     * 客服账号登录密码，格式为密码明文的32位加密MD5值。该密码仅用于在公众平台官网的多客服功能中使用，
     * 若不使用多客服功能，则不必设置密码客服密码，必须是16位的密码，必填
     */
    private String password;
}
