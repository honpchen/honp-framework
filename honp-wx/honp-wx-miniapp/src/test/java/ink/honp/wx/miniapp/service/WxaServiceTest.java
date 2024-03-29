package ink.honp.wx.miniapp.service;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.wx.cgi.entity.response.WxAccessTokenResponse;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.client.impl.WxaClientImpl;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.config.WxaDefaultConfig;

/**
 * @author jeffchen
 * date    2024/01/05 15:39
 */
public class WxaServiceTest {

    private static final String APPID = "xxxxx";
    private static final String SECRET = "xxxxxx";
    private static final String ACCESS_TOKEN = "76_yMw60CWlAeeh9xoQ4HbtuRrvt-wzV2ztfA5rq006KvF1kE866plxk55X8iHnyhLBznAgYbSZ5EZUkQbqnsXnLBlw5wxXSVK9Ykkvcz6_P3KJUsdNKzxRdINEp1wFPUdAIALVA";
    private static final Integer EXPIRES_IN = 7200;


    public WxaClient getWxaClient() {



        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET, HttpLogLevel.BODY);


        WxAccessTokenResponse tokenInfo = new WxAccessTokenResponse();
        tokenInfo.setAccessToken(ACCESS_TOKEN);
        tokenInfo.setExpiresIn(EXPIRES_IN);

        wxaConfig.refreshAccessToken(tokenInfo.getAccessToken(), tokenInfo.getExpiresIn());
        return new WxaClientImpl(wxaConfig);
    }
}
