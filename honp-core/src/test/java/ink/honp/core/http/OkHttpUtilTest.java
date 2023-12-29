package ink.honp.core.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2023/12/29 15:10
 */
@Slf4j
class OkHttpUtilTest {

    @Test
    @DisplayName("Http Get")
    void testGet() {
        String url = "https://www.baidu.com";
        String body = OkHttpUtil.get(url);

        Assertions.assertNotNull(body);

        log.info("Get [{}] response [{}]", url, body);
    }
}
