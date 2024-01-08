package ink.honp.wx.miniapp.entity.response.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 16:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaUserNotifyResponse extends WxResponse {

    @JsonProperty("notify_info")
    private WxaNotifyInfo notifyInfo;

    @Data
    public static class WxaNotifyInfo {

        /**
         * 卡片id
         */
        @JsonProperty("notify_type")
        private Integer notifyType;

        /**
         * 上次有效推送的卡片状态与状态相关字段，没推送过为空字符串。
         */
        @JsonProperty("content_json")
        private String contentJson;

        /**
         * code 状态：0 正常；1 有风险；2 异常；10 用户拒收本次code
         */
        @JsonProperty("code_state")
        private Integer codeState;

        /**
         * code 过期时间，秒级时间戳
         */
        @JsonProperty("code_expire_time")
        private Long codeExpireTime;
    }
}
