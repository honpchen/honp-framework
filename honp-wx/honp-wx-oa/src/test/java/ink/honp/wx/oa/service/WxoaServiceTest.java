package ink.honp.wx.oa.service;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.wx.oa.client.WxoaClient;
import ink.honp.wx.oa.client.impl.WxoaClientImpl;
import ink.honp.wx.oa.config.WxoaConfig;
import ink.honp.wx.oa.config.WxoaDefaultConfig;

/**
 * @author jeffchen
 * date    2024/01/09 16:29
 */
public class WxoaServiceTest {

    public WxoaClient getWxoaClient() {
        String accessToken = "76_INsp9fmCe4iBjTgzGrVPULK5QXlMyBjjIjkYpPLgdGekbMWiyx27YHjlrj7oG_ufFaPzg3xZSYYb_2NjCjCdlHf3IJNLEhZRqPLzsLXtyTBEVOrZm01q3rtNVPQMGDiAEAXRO";

        WxoaConfig wxoaConfig = new WxoaDefaultConfig("appid", "secret", HttpLogLevel.BODY);
        wxoaConfig.refreshAccessToken(accessToken, 7200);
        return new WxoaClientImpl(wxoaConfig);
    }
}
