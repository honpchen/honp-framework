package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastPushMessageRequest;
import ink.honp.wx.miniapp.service.WxaBroadcastMessageService;

/**
 * @author jeffchen
 * date    2024/01/08 17:00
 */
public class WxaBroadcastMessageServiceImpl implements WxaBroadcastMessageService {

    private final WxaClient wxaClient;

    public WxaBroadcastMessageServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public String pushMessage(WxaBroadcastPushMessageRequest pushMessageRequest) {
        String response = wxaClient.post(WxaUrlConstant.BroadcastMessage.PUSH, pushMessageRequest);

        return WxResponseParseUtil.parse(response, "message_id");
    }
}
