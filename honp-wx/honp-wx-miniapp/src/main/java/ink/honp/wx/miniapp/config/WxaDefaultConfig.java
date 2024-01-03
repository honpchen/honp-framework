package ink.honp.wx.miniapp.config;

import ink.honp.wx.core.entity.WxTokenInfo;
import lombok.Data;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
public class WxaDefaultConfig implements WxaConfig {

    private String appid;
    private String secret;
    private String token;
    private String encodingAesKey;

    private String accessToken;
    private long accessTokenExpireTimes;

    private final ReentrantLock accessTokenLock = new ReentrantLock();


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
    public void refreshAccessToken(WxTokenInfo tokenInfo) {
        this.accessToken = tokenInfo.getAccessToken();
        this.accessTokenExpireTimes = DateUtils.addSeconds(new Date(), tokenInfo.getExpiresIn()).getTime();
    }

    @Override
    public void expiredAccessToken() {
        this.accessTokenExpireTimes = 0;
    }
}
