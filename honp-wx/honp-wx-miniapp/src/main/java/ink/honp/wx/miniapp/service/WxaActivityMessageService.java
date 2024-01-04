package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.msg.WxaActivityMessageUpdateRequest;
import ink.honp.wx.miniapp.entity.request.msg.WxaMessageActivityIdCreateRequest;
import ink.honp.wx.miniapp.entity.response.msg.WxaMessageActivityIdResponse;

/**
 * @author jeffchen
 * date    2024/01/04 14:13
 */
public interface WxaActivityMessageService extends WxaService {

    /**
     * 创建 activity_id
     * <pre>
     *     该接口用于创建被分享动态消息或私密消息的 activity_id
     * </pre>
     * @param activityIdCreateRequest -
     * @return -
     */
    WxaMessageActivityIdResponse createActivityId(WxaMessageActivityIdCreateRequest activityIdCreateRequest);

    /**
     *  修改动态消息
     * <pre>
     *     该接口用于修改被分享的动态消息
     * </pre>
     * @param messageUpdateRequest -
     */
    void updateActivityMessage(WxaActivityMessageUpdateRequest messageUpdateRequest);

}
