package ink.honp.wx.oa.client;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.wx.oa.client.impl.WxoaClientImpl;
import ink.honp.wx.oa.config.WxoaConfig;
import ink.honp.wx.oa.config.WxoaDefaultConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/09 16:26
 */
@Slf4j
class WxoaClientTest {
    
    private static final String APP_ID = "xxxxxx";
    private static final String SECRET = "xxxxxx";
    
    @Test
    void testGetAccessToken() {
        WxoaConfig wxoaConfig = new WxoaDefaultConfig(APP_ID, SECRET, HttpLogLevel.BODY);
        WxoaClient wxoaClient = new WxoaClientImpl(wxoaConfig);

        String accessToken = wxoaClient.getAccessToken(false);
        Assertions.assertNotNull(accessToken);

        log.info("access token: {}", accessToken);
    }
}
