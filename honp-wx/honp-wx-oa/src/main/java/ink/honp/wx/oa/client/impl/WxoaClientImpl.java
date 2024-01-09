package ink.honp.wx.oa.client.impl;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.cgi.client.impl.WxCgiAbstractClient;
import ink.honp.wx.cgi.constant.WxCgiUrlConstant;
import ink.honp.wx.cgi.entity.request.WxStableAccessTokenGetRequest;
import ink.honp.wx.cgi.entity.response.WxAccessTokenResponse;
import ink.honp.wx.core.constant.WxGrantType;
import ink.honp.wx.core.exception.WxError;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.oa.client.WxoaClient;
import ink.honp.wx.oa.config.WxoaConfig;
import ink.honp.wx.oa.factory.WxoaServiceFactory;
import ink.honp.wx.oa.service.WxoaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jeff chen
 * @since 2024-01-01 17:45
 */
@Slf4j
public class WxoaClientImpl extends WxCgiAbstractClient implements WxoaClient {

    private final WxoaConfig wxoaConfig;
    private final WxoaServiceFactory wxoaServiceFactory;

    public WxoaClientImpl(WxoaConfig wxoaConfig) {
        super(wxoaConfig);
        this.wxoaConfig = wxoaConfig;
        this.wxoaServiceFactory = new WxoaServiceFactory(this);
    }

    @Override
    public WxoaConfig getConfig() {
        return this.wxoaConfig;
    }


    @Override
    public <T extends WxoaService> T getWxoaService(Class<T> clazz) {
        return wxoaServiceFactory.getWxaService(clazz);
    }


    @Override
    public WxAccessTokenResponse doGetAccessToken() {
        WxStableAccessTokenGetRequest tokenRequest = new WxStableAccessTokenGetRequest();
        tokenRequest.setAppid(wxoaConfig.getAppid());
        tokenRequest.setSecret(wxoaConfig.getSecret());
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
