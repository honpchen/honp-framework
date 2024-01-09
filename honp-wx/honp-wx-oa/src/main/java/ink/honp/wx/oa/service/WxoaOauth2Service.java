package ink.honp.wx.oa.service;

import ink.honp.wx.oa.entity.response.oauth.WxoaOauth2AccessTokenResponse;
import ink.honp.wx.oa.entity.response.oauth.WxoaOauthUserResponse;

/**
 * @author jeffchen
 * date    2024/01/09 16:55
 */
public interface WxoaOauth2Service extends WxoaService {

    /**
     * 通过code换取网页授权access_token
     * <pre>
     *     关于网页授权的两种scope的区别说明
     *     1. 以snsapi_base为scope发起的网页授权，是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。
     *          用户感知的就是直接进入了回调页（往往是业务页面）
     *     2. 以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的。但这种授权需要用户手动同意，并且由于用户同意过，
     *          所以无须关注，就可在授权后获取该用户的基本信息。
     *     用户管理类接口中的“获取用户基本信息接口”，是在用户和公众号产生消息交互或关注后事件推送后，才能根据用户OpenID来获取用户基本信息。
     *     这个接口，包括其他微信接口，都是需要该用户（即openid）关注了公众号后，才能调用成功的。
     * </pre>
     * @param code 网页授权 code
     * @return 网页授权access_token
     */
    WxoaOauth2AccessTokenResponse getAccessToken(String code);

    /**
     * 刷新access_token（如果需要）
     * <pre>
     *     由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，
     *     refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权。
     * </pre>
     * @param refreshToken 刷新access_token
     * @return 新的access_token
     */
    WxoaOauth2AccessTokenResponse refreshAccessToken(String refreshToken);

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * @param oauth2AccessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     * @param openid 用户的唯一标识
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return 用户信息
     */
    WxoaOauthUserResponse getUserInfo(String oauth2AccessToken, String openid, String lang);
}
