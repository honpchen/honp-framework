package ink.honp.wx.miniapp.client;

import ink.honp.core.util.JacksonUtil;
import ink.honp.core.util.ThreadUtil;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.config.WxaDefaultConfig;
import ink.honp.wx.miniapp.entity.response.user.WxaSessionInfoResponse;
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

    private static final String APPID = "xxxx";
    private static final String SECRET = "xxxx";

    @Test
    @DisplayName("并发获取 accessToken")
    void testMultiThreadGetAccessToken() {
        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET);
        
        WxaClient wxaClient = new WxaOkHttpClient(wxaConfig);

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
        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET);

        WxaClient wxaClient = new WxaOkHttpClient(wxaConfig);
        String accessToken = wxaClient.getAccessToken(false);

        Assertions.assertTrue(StringUtils.isNotBlank(accessToken));

        log.info("Wx miniApp accessToken:{}", accessToken);
    }

    @Test
    void testCode2Session() {
        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET);

        String jsCode = "0b1OWGGa18HXEG0DUmJa1jcMIh4OWGGg";

        WxaClient wxaClient = new WxaOkHttpClient(wxaConfig);
        WxaSessionInfoResponse sessionInfo = wxaClient.code2Session(jsCode);

        Assertions.assertNotNull(sessionInfo);
        log.info("Wx miniApp sessionInfo:{}", JacksonUtil.toJson(sessionInfo));
    }

    @Test
    @DisplayName("错误 jsCode 校验")
    void testCode2SessionWithErrorJsCode() {
        WxaConfig wxaConfig = new WxaDefaultConfig(APPID, SECRET);
        String jsCode = "0b1OWGGa18HXEG0DUmJa1jcMIh4OWGGg";

        WxaClient wxaClient = new WxaOkHttpClient(wxaConfig);
        WxException wxException = Assertions.assertThrows(WxException.class, () -> wxaClient.code2Session(jsCode));

        log.info("WXA jsCode error [code:{}, msg:{}]", wxException.getCode(), wxException.getMessage());
    }

}
