package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 11:37
 */
@Data
public class WxaBroadcastAssistantListResponse extends WxResponse {

    /**
     * 小助手个数
     */
    private Integer count;

    /**
     * 小助手最大个数
     */
    private Integer maxCount;

    /**
     * 小助手列表
     */
    private List<WxaBroadcastAssistant> list;


    @Data
    public static class WxaBroadcastAssistant {

        /**
         * openid
         */
        private String openid;

        /**
         * 昵称
         */
        private String nickname;

        /**
         * 微信号
         */
        private String alias;

        /**
         * 头像
         */
        private String heading;

        /**
         * 修改时间
         */
        private Long timestamp;
    }
}
