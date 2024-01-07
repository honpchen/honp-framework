package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.qrcode.WxaShortLinkGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkQueryRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaShortLinkResponse;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaUrlLinkGenerateResponse;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaUrlLinkResponse;

/**
 * @author jeffchen
 * date    2024/01/04 11:17
 */
public interface WxaUrlLinkService extends WxaService {

    /**
     * 获取加密URLLink
     * <pre>
     *     获取小程序 URL Link，适用于短信、邮件、网页、微信内等拉起小程序的业务场景。目前仅针对国内非个人主体的小程序开放
     * </pre>
     * @param generateUrlLinkRequest -
     * @return URLLink
     */
    String generateUrlLink(WxaUrlLinkGenerateRequest generateUrlLinkRequest);

    /**
     * 查询加密URLLink
     * <pre>
     *     该接口用于查询小程序加密 url_link 配置
     * </pre>
     * @param queryRequest -
     * @return UrlLink Info
     */
    WxaUrlLinkResponse queryUrlLink(WxaUrlLinkQueryRequest queryRequest);

    /**
     * 获取短链
     * <pre>
     *     获取小程序 Short Link，适用于微信内拉起小程序的业务场景。
     *     目前只开放给电商类目(具体包含以下一级类目：电商平台、商家自营、跨境电商)。
     *     通过该接口，可以选择生成到期失效和永久有效的小程序短链
     * </pre>
     * @param generateRequest -
     * @return ShortLink
     */
    String generateShortLink(WxaShortLinkGenerateRequest generateRequest);
}
