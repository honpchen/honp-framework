package ink.honp.wx.miniapp.entity.response.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 11:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaQuotaInfoResponse extends WxResponse {

    @JsonProperty("quota_info")
    private WxaQuotaInfo quotaInfo;

    @Data
    public static class WxaQuotaInfo {
        /**
         * URL Scheme（加密+明文）/加密 URL Link 单天剩余访问次数
         */
        @JsonProperty("remain_visit_quota")
        private Integer remainVisitQuota;
    }


}
