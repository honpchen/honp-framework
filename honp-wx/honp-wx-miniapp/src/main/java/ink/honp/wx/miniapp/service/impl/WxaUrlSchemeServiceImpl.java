package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaNfcSchemeGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaSchemeGenerateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaSchemeQueryRequest;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaSchemeInfoResponse;
import ink.honp.wx.miniapp.service.WxaUrlSchemeService;

/**
 * @author jeff chen
 * @since 2024-01-07 21:51
 */
public class WxaUrlSchemeServiceImpl implements WxaUrlSchemeService {

    private static final String OPEN_LINK = "openlink";

    private final WxaClient wxaClient;

    public WxaUrlSchemeServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public String generateNfcScheme(WxaNfcSchemeGenerateRequest nfcSchemeRequest) {
        String repContent = wxaClient.post(WxaUrlConstant.Scheme.GENERATE_NFC_SCHEME, nfcSchemeRequest);

        return WxResponseParseUtil.parse(repContent, OPEN_LINK);
    }

    @Override
    public String generateScheme(WxaSchemeGenerateRequest schemeGenerateRequest) {
        String repContent = wxaClient.post(WxaUrlConstant.Scheme.GENERATE_SCHEME, schemeGenerateRequest);

        return WxResponseParseUtil.parse(repContent, OPEN_LINK);
    }

    @Override
    public WxaSchemeInfoResponse queryScheme(WxaSchemeQueryRequest schemeQueryRequest) {

        return wxaClient.post(WxaUrlConstant.Scheme.QUERY_SCHEME, schemeQueryRequest, WxaSchemeInfoResponse.class);
    }
}
