package ink.honp.wx.miniapp.entity.response.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 17:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaAnalysisDailySummaryResponse extends WxResponse {

    private List<DailySummary> list;

    @Data
    public static class DailySummary {

        /**
         * 时间
         */
        @JsonProperty("ref_date")
        private String refDate;

        /**
         * 累计用户数
         */
        @JsonProperty("visit_total")
        private Long visitTotal;

        /**
         * 转发次数
         */
        @JsonProperty("share_pv")
        private Long sharePv;

        /**
         * 转发人数
         */
        @JsonProperty("share_uv")
        private Long shareUv;
    }
}
