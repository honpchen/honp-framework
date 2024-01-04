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
public class WxaAnalysisRetainResponse extends WxResponse {

    /**
     * 时间
     */
    @JsonProperty("ref_date")
    private String refDate;

    /**
     * 新增用户留存
     */
    @JsonProperty("visit_uv_new")
    private List<Uv> visitUvNew;

    /**
     * 活跃用户留存
     */
    @JsonProperty("visit_uv")
    private List<Uv> visitUv;

    @Data
    public static class Uv {

        /**
         * 标识
         */
        private Integer key;

        /**
         * key对应日期的新增用户数/活跃用户数（key=0时）或留存用户数（k>0时）
         */
        private Integer value;
    }
}
