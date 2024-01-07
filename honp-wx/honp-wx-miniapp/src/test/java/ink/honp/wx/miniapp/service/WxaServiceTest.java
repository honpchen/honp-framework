package ink.honp.wx.miniapp.service;

import ink.honp.core.http.interceptor.OkHttpLogInterceptor;
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
    private static final String ACCESS_TOKEN = "76_U9VSOfVZOVljQ_5W3Sua7QP1VlOtMUSwtCax7qrx3uDZukaoyL9XN5vPW3WijUw2mtK0OErKAj61Hr4aI5NaxZwyA0PDwJvL4ncTGfVjwsBJsu1z2H1wYwYuHJwECOeAEALJV";
    private static final Integer EXPIRES_IN = 7200;
    private static final Integer TIMEOUT = 2 * 60;


    public WxaClient getWxaClient() {



        WxaConfig wxaConfig = new WxaDefaultConfig()
                .setAppid(APPID)
                .setSecret(SECRET);

        WxTokenInfo tokenInfo = new WxTokenInfo();
        tokenInfo.setAccessToken(ACCESS_TOKEN);
        tokenInfo.setExpiresIn(EXPIRES_IN);

        wxaConfig.refreshAccessToken(tokenInfo);
        WxaClientImpl wxaClient = new WxaClientImpl(wxaConfig);
        wxaClient.setOkHttpClient(new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new OkHttpLogInterceptor(wxaClient.getClientTag(), OkHttpLogInterceptor.Level.BODY))
                .build());

        return wxaClient;
    }
}
