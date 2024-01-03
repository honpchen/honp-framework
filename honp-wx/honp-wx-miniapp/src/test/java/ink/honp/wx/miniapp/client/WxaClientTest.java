package ink.honp.wx.miniapp.client;

import ink.honp.core.util.JacksonUtil;
import ink.honp.core.util.ThreadUtil;
import ink.honp.wx.miniapp.client.impl.WxaClientImpl;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.config.WxaDefaultConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jeffchen
 * date    2024/01/03 11:18
 */
@Slf4j
class WxaClientTest {

    private static final String APPID = "xxxxxx";
    private static final String SECRET = "xxxxxx";

    @Test
    @DisplayName("并发获取 accessToken")
    void testMultiThreadGetAccessToken() {
        WxaConfig wxaConfig = new WxaDefaultConfig()
                .setAppid(APPID)
                .setSecret(SECRET);
        
        WxaClient wxaClient = new WxaClientImpl(wxaConfig);

        Set<String> accessTokens = new HashSet<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                String accessToken = wxaClient.getAccessToken(false);
                accessTokens.add(accessToken);
            }));
        }
        threads.parallelStream().forEach(Thread::start);
        ThreadUtil.sleep(1000 * 10);
        Assertions.assertEquals(1, accessTokens.size());
        log.info("Wx miniApp accessToken:{}", JacksonUtil.toJson(accessTokens));
    }


    @Test
    @DisplayName("获取 accessToken")
    void testGetAccessToken() {
        WxaConfig wxaConfig = new WxaDefaultConfig()
                .setAppid(APPID)
                .setSecret(SECRET);

        WxaClient wxaClient = new WxaClientImpl(wxaConfig);
        String accessToken = wxaClient.getAccessToken(false);

        Assertions.assertTrue(StringUtils.isNotBlank(accessToken));

        log.info("Wx miniApp accessToken:{}", accessToken);
    }
}
