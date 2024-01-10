package ink.honp.wx.miniapp.config;

import ink.honp.core.http.enums.HttpLogLevel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 小程序默认配置实现
 * @author jeffchen
 * date    2024/01/03 10:54
 */
@Data
public class WxaDefaultConfig implements WxaConfig {

    private static final Integer DEFAULT_TIMEOUT = 2 * 60;
    private static final String DEFAULT_CLIENT_TAG = "WX MINI-APP";

    private final String appid;
    private final String secret;
    private final String token;
    private final String encodingAesKey;
    private final Integer timeout;
    private final HttpLogLevel level;

    private String accessToken;
    private long accessTokenExpireTimes;

    private final ReentrantLock accessTokenLock = new ReentrantLock();

    public WxaDefaultConfig (String appid, String secret) {
        this(appid, secret, DEFAULT_TIMEOUT, HttpLogLevel.BASIC);
    }

    public WxaDefaultConfig (String appid, String secret, Integer timeout, HttpLogLevel level) {
        this(appid, secret, null, null, timeout, level);
    }

    public WxaDefaultConfig (String appid, String secret, String token, String encodingAesKey) {
        this(appid, secret, token, encodingAesKey, DEFAULT_TIMEOUT, HttpLogLevel.BASIC);
    }


    public WxaDefaultConfig (String appid, String secret,
                             String token, String encodingAesKey,
                             Integer timeout, HttpLogLevel level) {
        this.appid = appid;
        this.secret = secret;
        this.token = token;
        this.encodingAesKey = encodingAesKey;
        this.timeout = timeout;
        this.level = level;
    }


    @Override
    public boolean accessTokenNotExpired() {
        return StringUtils.isNotBlank(accessToken)
                && (accessTokenExpireTimes -  System.currentTimeMillis()) > 100;
    }


    @Override
    public Lock getAccessTokenLock() {
        return this.accessTokenLock;
    }

    @Override
    public void refreshAccessToken(String accessToken, Integer expiresIn) {
        this.accessToken = accessToken;
        this.accessTokenExpireTimes = DateUtils.addSeconds(new Date(), expiresIn - 10).getTime();
    }

    @Override
    public void expiredAccessToken() {
        this.accessTokenExpireTimes = 0;
    }
}
