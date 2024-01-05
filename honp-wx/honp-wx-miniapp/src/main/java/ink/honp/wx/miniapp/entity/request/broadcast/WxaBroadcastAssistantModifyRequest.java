package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 11:33
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastAssistantModifyRequest implements WxRequest {

    /**
     * 房间号，必填
     */
    private Long roomId;

    /**
     * 用户微信号，必填
     */
    private String username;

    /**
     * 用户微信昵称，必填
     */
    private String nickname;
}
