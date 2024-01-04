package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.user.WxaUserGetPaidUnionidRequest;
import ink.honp.wx.miniapp.entity.request.user.WxaPhoneNumberGetRequest;
import ink.honp.wx.miniapp.entity.response.user.WxaUserOpenIdResponse;
import ink.honp.wx.miniapp.entity.response.user.WxaUserPhoneInfoResponse;
import ink.honp.wx.miniapp.entity.response.user.WxaUserUnionIdResponse;
import lombok.NonNull;

/**
 * @author jeffchen
 * date    2024/01/03 17:34
 */
public interface WxaUserService extends WxaService {

    /**
     * 获取小程序插件的openid
     *
     * @param code 通过 wx.pluginLogin 获得的插件用户标志凭证 code，有效时间为5分钟，一个 code 只能获取一次 openpid
     * @return 插件用户的唯一标识
     */
    WxaUserOpenIdResponse getPluginOpenPId(@NonNull String code);

    /**
     * 支付后获取 Unionid
     * <pre>
     *     注意
     *      - 调用前需要用户完成支付，且在支付后的五分钟内有效。
     *      - 使用微信支付订单号（transaction_id）和微信支付商户订单号和微信支付商户号（out_trade_no 及 mch_id），二选一
     * </pre>.
     * @param paidUnionidRequest 请求参数
     * @return 用户 unionid
     */
    WxaUserUnionIdResponse getPaidUnionid(WxaUserGetPaidUnionidRequest paidUnionidRequest);


    /**
     * 获取手机号
     * <pre>
     *     该接口用于将code换取用户手机号。 说明，每个code只能使用一次，code的有效期为5min
     * </pre>
     *
     * @param phoneNumberGetRequest 请求参数
     * @return 用户手机号
     */
    WxaUserPhoneInfoResponse getPhoneNumber(WxaPhoneNumberGetRequest phoneNumberGetRequest);
}
