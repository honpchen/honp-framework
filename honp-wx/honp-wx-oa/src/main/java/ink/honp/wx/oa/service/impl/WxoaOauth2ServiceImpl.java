package ink.honp.wx.oa.service.impl;

import ink.honp.wx.core.executor.WxGetRequestExecutor;
import ink.honp.wx.core.handler.WxSimpleResponseHandler;
import ink.honp.wx.oa.client.WxoaClient;
import ink.honp.wx.oa.entity.response.oauth.WxoaOauth2AccessTokenResponse;
import ink.honp.wx.oa.entity.response.oauth.WxoaOauthUserResponse;
import ink.honp.wx.oa.service.WxoaOauth2Service;

/**
 * @author jeffchen
 * date    2024/01/09 17:15
 */
public class WxoaOauth2ServiceImpl implements WxoaOauth2Service {

    private final WxoaClient wxoaClient;

    public WxoaOauth2ServiceImpl(WxoaClient wxoaClient) {
        this.wxoaClient = wxoaClient;
    }

    @Override
    public WxoaOauth2AccessTokenResponse getAccessToken(String code) {

        return null;
    }

    @Override
    public WxoaOauth2AccessTokenResponse refreshAccessToken(String refreshToken) {
        return null;
    }

    @Override
    public WxoaOauthUserResponse getUserInfo(String oauth2AccessToken, String openid, String lang) {
        return null;
    }
}
