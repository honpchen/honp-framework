package ink.honp.wx.miniapp.entity.request.broadcast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 11:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class WxaBroadcastAssistantModifyRequest extends WxaBroadRoomIdRequest {

    /**
     * 用户微信号，必填
     */
    private String username;

    /**
     * 用户微信昵称，必填
     */
    private String nickname;
}
