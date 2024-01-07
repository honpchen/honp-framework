package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaShortLinkGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaUrlLinkQueryRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaShortLinkResponse;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaUrlLinkGenerateResponse;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaUrlLinkResponse;
import ink.honp.wx.miniapp.service.WxaUrlLinkService;

import java.net.URL;

/**
 * @author jeff chen
 * @since 2024-01-07 22:24
 */
public class WxaUrlLinkServiceImpl implements WxaUrlLinkService {

    private static final String URL_LINK = "url_link";
    private static final String LINK = "link";

    private final WxaClient wxaClient;

    public WxaUrlLinkServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public String generateUrlLink(WxaUrlLinkGenerateRequest generateUrlLinkRequest) {
        String response = wxaClient.post(WxaUrlConstant.UrlLink.GENERATE_URL_LINK, generateUrlLinkRequest);

        return WxResponseParseUtil.parse(response, URL_LINK);
    }

    @Override
    public WxaUrlLinkResponse queryUrlLink(WxaUrlLinkQueryRequest queryRequest) {

        return wxaClient.post(WxaUrlConstant.UrlLink.QUERY_URL_LINK, queryRequest, WxaUrlLinkResponse.class);
    }

    @Override
    public String generateShortLink(WxaShortLinkGenerateRequest generateRequest) {

        String response = wxaClient.post(WxaUrlConstant.UrlLink.GENERATE_SHORT_LINK, generateRequest);

        return WxResponseParseUtil.parse(response, LINK);
    }

}
