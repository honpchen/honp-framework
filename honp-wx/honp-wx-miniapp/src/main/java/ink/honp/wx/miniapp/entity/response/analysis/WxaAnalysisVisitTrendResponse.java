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
public class WxaAnalysisVisitTrendResponse extends WxResponse {

    /**
     * 时间
     */
    @JsonProperty("ref_date")
    private String refDate;

    /**
     * 打开次数
     */
    @JsonProperty("session_cnt")
    private Long sessionCnt;

    /**
     * 访问次数
     */
    @JsonProperty("visit_pv")
    private Long visitPv;

    /**
     * 访问人数
     */
    @JsonProperty("visit_uv")
    private Long visitUv;

    /**
     * 新用户数
     */
    @JsonProperty("visit_uv_new")
    private Long visitUvNew;

    /**
     * 人均停留时长 (浮点型，单位：秒)
     */
    @JsonProperty("stay_time_uv")
    private Double stayTimeUv;

    /**
     * 次均停留时长 (浮点型，单位：秒)
     */
    @JsonProperty("stay_time_session")
    private Double stayTimeSession;

    /**
     * 平均访问深度 (浮点型)
     */
    @JsonProperty("visit_depth")
    private Double visitDepth;
}
