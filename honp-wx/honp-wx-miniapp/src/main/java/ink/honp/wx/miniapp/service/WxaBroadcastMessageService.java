package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastPushMessageRequest;

/**
 * @author jeffchen
 * date    2024/01/05 14:46
 */
public interface WxaBroadcastMessageService extends WxaService {

    /**
     * 发送直播开始事件
     * <pre>
     *     该接口用于向长期订阅用户群发直播间开始事件
     * </pre>
     * @param pushMessageRequest -
     * @return 此次群发消息的标识ID，用于对应【长期订阅群发结果回调】的message_id
     */
    String pushMessage(WxaBroadcastPushMessageRequest pushMessageRequest);
}
