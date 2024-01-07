package ink.honp.wx.miniapp.entity.response.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 11:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaUrlLinkResponse extends WxaQuotaInfoResponse {

    @JsonProperty("url_link_info")
    private WxaUrlLinkInfo urlLinkInfo;

    @Data
    public static class WxaUrlLinkInfo {
        /**
         * 小程序 appid
         */
        private String appid;

        /**
         * 小程序页面路径
         */
        private String path;

        /**
         * 小程序页面query
         */
        private String query;

        /**
         * 创建时间，为 Unix 时间戳
         */
        @JsonProperty("create_time")
        private Long createTime;

        /**
         * 到期失效时间，为 Unix 时间戳，0 表示永久生效
         */
        @JsonProperty("expire_time")
        private Long expireTime;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
         */
        @JsonProperty("env_version")
        private String envVersion;
    }


}
