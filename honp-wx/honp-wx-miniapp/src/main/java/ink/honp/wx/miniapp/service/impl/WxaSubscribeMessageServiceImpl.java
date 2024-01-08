package ink.honp.wx.miniapp.service.impl;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.msg.*;
import ink.honp.wx.miniapp.entity.response.msg.*;
import ink.honp.wx.miniapp.service.WxaSubscribeMessageService;

import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/08 10:15
 */
public class WxaSubscribeMessageServiceImpl implements WxaSubscribeMessageService {

    private final WxaClient wxaClient;

    public WxaSubscribeMessageServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaCategoryResponse getCategory() {
        return wxaClient.get(WxaUrlConstant.Message.GET_CATEGORY, null, WxaCategoryResponse.class);
    }

    @Override
    public WxaPubTemplateTitleListResponse getPubTemplateTitleList(WxaPubTemplateTitlePageRequest pageRequest) {

        return wxaClient.get(WxaUrlConstant.Message.GET_PUB_TEMPLATE_TITLE_LIST, pageRequest, WxaPubTemplateTitleListResponse.class);
    }

    @Override
    public WxaPubTemplateKeyWordResponse getPubTemplateKeyWordsById(Long tid) {

        return wxaClient.get(String.format(WxaUrlConstant.Message.GET_PUB_TEMPLATE_KEYWORDS, tid),
                null, WxaPubTemplateKeyWordResponse.class);
    }

    @Override
    public WxaMessageTemplateResponse getMessageTemplateList() {

        return wxaClient.get(WxaUrlConstant.Message.GET_TEMPLATE, null, WxaMessageTemplateResponse.class);
    }

    @Override
    public void sendMessage(WxaMessageSendRequest sendRequest) {

        wxaClient.post(WxaUrlConstant.Message.SUBSCRIBE_MESSAGE_SEND, sendRequest);
    }

    @Override
    public WxaMessageTemplateIdResponse addMessageTemplate(WxaMessageTemplateAddRequest addRequest) {

        return wxaClient.post(WxaUrlConstant.Message.ADD_TEMPLATE, addRequest, WxaMessageTemplateIdResponse.class);
    }

    @Override
    public void setUserNotify(WxaUserNotifySetRequest notifySetRequest) {
        wxaClient.post(WxaUrlConstant.Message.SET_USER_NOTIFY, notifySetRequest);
    }

    @Override
    public WxaUserNotifyResponse getUserNotify(WxaUserNotifyRequest notifyGetRequest) {

        return wxaClient.post(WxaUrlConstant.Message.GET_USER_NOTIFY,  notifyGetRequest, WxaUserNotifyResponse.class);

    }

    @Override
    public void setUserNotifyExt(WxaUserNotifyExtSetRequest notifyExtSetRequest) {

        wxaClient.post(WxaUrlConstant.Message.SET_USER_NOTIFY_EXT, notifyExtSetRequest);
    }

    @Override
    public void deleteMessageTemplate(String priTmplId) {
        Map<String, String> requestParams = CollectionUtil.newHashMap();
        requestParams.put("priTmplId", priTmplId);

        wxaClient.post(WxaUrlConstant.Message.DELETE_TEMPLATE, requestParams);
    }

}
