package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.qrcode.WxaGenerateNfcSchemeRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaGenerateSchemeRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaSchemeQueryRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaOpenLinkResponse;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaSchemeInfoResponse;

/**
 * @author jeffchen
 * date    2024/01/03 18:32
 */
public interface WxaUrlSchemeService extends WxaService {

    /**
     * 获取 NFC 的小程序 scheme
     * <pre>
     *     该接口用于获取用于 NFC 的小程序 scheme 码，适用于 NFC 拉起小程序的业务场景。目前仅针对国内非个人主体的小程序开放
     * </pre>
     * @param nfcSchemeRequest -
     * @return 生成的小程序 scheme 码
     */
    WxaOpenLinkResponse generateNfcScheme(WxaGenerateNfcSchemeRequest nfcSchemeRequest);

    /**
     * 获取加密 scheme 码
     * <pre>
     *     该接口用于获取小程序 scheme 码，适用于短信、邮件、外部网页、微信内等拉起小程序的业务场景。目前仅针对国内非个人主体的小程序开放
     * </pre>
     * @param generateSchemeRequest -
     * @return 生成的小程序 scheme 码
     */
    WxaOpenLinkResponse generateScheme(WxaGenerateSchemeRequest generateSchemeRequest);

    /**
     * 查询scheme码
     * <pre>
     *     该接口用于查询小程序 scheme 码，包括加密 scheme 和明文 scheme
     * </pre>
     * @param schemeQueryRequest -
     * @return -
     */
    WxaSchemeInfoResponse queryScheme(WxaSchemeQueryRequest schemeQueryRequest);
}
