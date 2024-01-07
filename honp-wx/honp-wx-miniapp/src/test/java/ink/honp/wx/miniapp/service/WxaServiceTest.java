package ink.honp.wx.miniapp.service;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.core.http.interceptor.OkHttpDefaultLogInterceptor;
import ink.honp.wx.core.entity.WxTokenInfo;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.client.impl.WxaClientImpl;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.config.WxaDefaultConfig;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author jeffchen
 * date    2024/01/05 15:39
 */
public class WxaServiceTest {

    private static final String APPID = "xxxxxx";
    private static final String SECRET = "xxxxxxx";
    private static final String ACCESS_TOKEN = "76_fwVi8tDNbD2ZYoe9G0G_xf2E4eU-5b9TUh6IiIztKeMhaoPMRw_CZt0u7QPVPoqFH0bKi5J4SYYLnsLc58bmO2Diiao5qDDACtcFGuJUtp2GwZTt8yap14-Zg6AKFPaABAXSC";
    private static final Integer EXPIRES_IN = 7200;
    private static final Integer TIMEOUT = 2 * 60;


    public WxaClient getWxaClient() {



        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET, HttpLogLevel.BODY);


        WxTokenInfo tokenInfo = new WxTokenInfo();
        tokenInfo.setAccessToken(ACCESS_TOKEN);
        tokenInfo.setExpiresIn(EXPIRES_IN);

        wxaConfig.refreshAccessToken(tokenInfo);
        return new WxaClientImpl(wxaConfig);
    }
}
