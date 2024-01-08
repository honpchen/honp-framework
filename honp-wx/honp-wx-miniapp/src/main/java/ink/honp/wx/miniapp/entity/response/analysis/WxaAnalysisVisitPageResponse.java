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
public class WxaAnalysisVisitPageResponse extends WxResponse {

    /**
     * 时间
     */
    @JsonProperty("ref_date")
    private String refDate;

    private List<WxaVisitPageInfo> list;

    @Data
    public static class WxaVisitPageInfo {
        /**
         * 页面路径
         */
        @JsonProperty("page_path")
        private String pagePath;

        /**
         * 访问次数
         */
        @JsonProperty("page_visit_pv")
        private Long pageVisitPv;

        /**
         * 访问人数
         */
        @JsonProperty("page_visit_uv")
        private Long pageVisitUv;

        /**
         * 次均停留时长
         */
        @JsonProperty("page_staytime_pv")
        private Double pageStaytimePv;

        /**
         * 进入页次数
         */
        @JsonProperty("entrypage_pv")
        private Long entrypagePv;

        /**
         * 退出页次数
         */
        @JsonProperty("exitpage_pv")
        private Long exitpagePv;

        /**
         * 转发次数
         */
        @JsonProperty("page_share_pv")
        private Long pageSharePv;

        /**
         * 转发人数
         */
        @JsonProperty("page_share_uv")
        private Long pageShareUv;

    }
}
