package ink.honp.wx.miniapp.client.impl;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.cgi.client.impl.WxCgiAbstractClient;
import ink.honp.wx.cgi.constant.WxCgiUrlConstant;
import ink.honp.wx.core.constant.WxGrantType;
import ink.honp.wx.cgi.entity.response.WxAccessTokenResponse;
import ink.honp.wx.cgi.entity.request.WxStableAccessTokenGetRequest;
import ink.honp.wx.core.exception.WxError;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.config.WxaConfig;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.response.user.WxaSessionInfoResponse;
import ink.honp.wx.miniapp.factory.WxaServiceFactory;
import ink.honp.wx.miniapp.service.WxaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jeff chen
 * @since 2024-01-01 17:45
 */
@Slf4j
public class WxaClientImpl extends WxCgiAbstractClient implements WxaClient {

    private final WxaConfig wxaConfig;
    private final WxaServiceFactory wxaServiceFactory;

    public WxaClientImpl(WxaConfig wxaConfig) {
        super(wxaConfig);
        this.wxaConfig = wxaConfig;
        wxaServiceFactory = new WxaServiceFactory(this);
    }

    @Override
    public WxaConfig getConfig() {
        return this.wxaConfig;
    }

    @Override
    public WxaSessionInfoResponse code2Session(String jsCode) {
        String url = String.format(WxaUrlConstant.Login.CODE_2_SESSION,
                wxaConfig.getAppid(), wxaConfig.getSecret(), jsCode);

        // jsCode 不能重复使用，禁用重试
        String content = execute(getGetRequestExecutor(), url,
                null, getResponseHandler(), 0, -1);
        if (StringUtils.isNotBlank(content)) {
            return JacksonUtil.toBean(content, WxaSessionInfoResponse.class);
        }

        return null;
    }


    @Override
    public <T extends WxaService> T getWxaService(Class<T> clazz) {
        return wxaServiceFactory.getWxaService(clazz);
    }


    @Override
    public WxAccessTokenResponse doGetAccessToken() {
        WxStableAccessTokenGetRequest tokenRequest = new WxStableAccessTokenGetRequest();
        tokenRequest.setAppid(wxaConfig.getAppid());
        tokenRequest.setSecret(wxaConfig.getSecret());
        tokenRequest.setGrantType(WxGrantType.CLIENT_CREDENTIAL);
        tokenRequest.setForceRefresh(false);

        String content = execute(getPostRequestExecutor(), WxCgiUrlConstant.STABLE_TOKEN, tokenRequest,
                getResponseHandler(), 1, MAX_RETRY_COUNT);
        if (StringUtils.isNotBlank(content)) {
            return JacksonUtil.toBean(content, WxAccessTokenResponse.class);
        }
        throw new WxException(WxError.GET_ACCESS_TOKEN_ERROR);
    }


}
