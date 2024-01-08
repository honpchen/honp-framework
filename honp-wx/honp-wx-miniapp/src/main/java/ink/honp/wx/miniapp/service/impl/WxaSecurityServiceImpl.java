package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.sec.WxaMediaCheckAsyncRequest;
import ink.honp.wx.miniapp.entity.request.sec.WxaMsgSecCheckRequest;
import ink.honp.wx.miniapp.entity.request.sec.WxaUserRiskRankGetRequest;
import ink.honp.wx.miniapp.entity.response.sec.WxaMsgSecCheckResponse;
import ink.honp.wx.miniapp.entity.response.sec.WxaUserRiskRankResponse;
import ink.honp.wx.miniapp.service.WxaSecurityService;

/**
 * @author jeffchen
 * date    2024/01/08 13:47
 */
public class WxaSecurityServiceImpl implements WxaSecurityService {

    private static final String TRACE_ID = "trace_id";

    private final WxaClient wxaClient;

    public WxaSecurityServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaMsgSecCheckResponse msgSecCheck(WxaMsgSecCheckRequest msgSecCheckRequest) {

        return wxaClient.post(WxaUrlConstant.Security.MSG_SEC_CHECK, msgSecCheckRequest, WxaMsgSecCheckResponse.class);
    }

    @Override
    public String mediaCheckAsync(WxaMediaCheckAsyncRequest mediaCheckAsyncRequest) {

        String content = wxaClient.post(WxaUrlConstant.Security.MEDIA_CHECKA_SYNC, mediaCheckAsyncRequest);

        return WxResponseParseUtil.parse(content, TRACE_ID);
    }

    @Override
    public WxaUserRiskRankResponse getUserRiskRank(WxaUserRiskRankGetRequest userRiskRankGetRequest) {

        return wxaClient.post(WxaUrlConstant.Security.GET_USER_RISK_RANK, userRiskRankGetRequest, WxaUserRiskRankResponse.class);
    }
}
