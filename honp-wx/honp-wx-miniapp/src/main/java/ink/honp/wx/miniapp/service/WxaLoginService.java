package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.response.WxaSessionInfo;

/**
 * @author jeffchen
 * date    2024/01/03 17:03
 */
public interface WxaLoginService extends WxaService {

    /**
     * 登录凭证校验
     *
     * @param jsCode 登录时获取的 code，可通过wx.login获取
     * @return session info
     */
    WxaSessionInfo code2Session(String jsCode);
}
