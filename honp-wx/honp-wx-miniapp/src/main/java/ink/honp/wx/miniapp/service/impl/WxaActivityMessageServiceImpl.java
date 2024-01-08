package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.msg.WxaActivityMessageUpdateRequest;
import ink.honp.wx.miniapp.entity.request.msg.WxaMessageActivityIdCreateRequest;
import ink.honp.wx.miniapp.entity.response.msg.WxaMessageActivityIdResponse;
import ink.honp.wx.miniapp.service.WxaActivityMessageService;

/**
 * @author jeffchen
 * date    2024/01/08 10:02
 */
public class WxaActivityMessageServiceImpl implements WxaActivityMessageService {

    private final WxaClient wxaClient;

    public WxaActivityMessageServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaMessageActivityIdResponse createActivityId(WxaMessageActivityIdCreateRequest activityIdCreateRequest) {

        return wxaClient.get(WxaUrlConstant.Message.CREATE_ACTIVITY_ID, activityIdCreateRequest, WxaMessageActivityIdResponse.class);
    }

    @Override
    public void updateActivityMessage(WxaActivityMessageUpdateRequest messageUpdateRequest) {

        wxaClient.post(WxaUrlConstant.Message.UPDATE_ACTIVITY_MSG, messageUpdateRequest);
    }
}
