package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 11:42
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastAssistantAddRequest implements WxRequest {

    /**
     * 房间ID
     */
    private Long roomId;

    /**
     * 用户数组
     */
    private List<WxaBroadcastAssistantUser> users;

    @Data
    public static class WxaBroadcastAssistantUser {

        /**
         * 微信号
         */
        private String username;

        /**
         * 昵称
         */
        private String nickname;
    }
}
