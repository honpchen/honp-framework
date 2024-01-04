package ink.honp.wx.miniapp.entity.request.msg;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 14:38
 */
@Data
@Accessors(chain = true)
public class WxaMessageActivityIdCreateRequest implements WxRequest {

    /**
     * 为私密消息创建activity_id时，指定分享者为unionid用户。其余用户不能用此activity_id分享私密消息。
     * openid与unionid填一个即可
     */
    private String unionid;

    /**
     * 为私密消息创建activity_id时，指定分享者为openid用户。其余用户不能用此activity_id分享私密消息。
     * openid与unionid填一个即可
     */
    private String openid;
}
