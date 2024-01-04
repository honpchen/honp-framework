package ink.honp.wx.miniapp.entity.response.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.miniapp.entity.response.qrcode.WxaQuotaInfoResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 11:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaSchemeInfoResponse extends WxaQuotaInfoResponse {

    @JsonProperty("scheme_info")
    private SchemeInfo schemeInfo;

    @Data
    public static class SchemeInfo {

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
        private Long createTime;

        /**
         * 到期失效时间，为 Unix 时间戳，0 表示永久生效
         */
        private Long expireTime;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"
         */
        private String envVersion;
    }
}
