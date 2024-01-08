package ink.honp.wx.miniapp.entity.response.sec;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 17:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaMsgSecCheckResponse extends WxResponse {

    /**
     * 详细检测结果
     */
    private WxaMsgSecCheckDetail detail;

    /**
     * 唯一请求标识，标记单次请求
     */
    @JsonProperty("trace_id")
    private String traceId;

    /**
     * 综合结果
     */
    private WxaMsgSecCheckResult result;

    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class WxaMsgSecCheckDetail extends WxaMsgSecCheckResult {

        /**
         * 策略类型
         */
        private String strategy;

        /**
         * 错误码，仅当该值为0时，该项结果有效
         */
        private Integer errcode;

        /**
         * 命中的自定义关键词
         */
        private String keyword;

        /**
         * 0-100，代表置信度，越高代表越有可能属于当前返回的标签（label）
         */
        private Integer prob;
    }

    @Data
    public static class WxaMsgSecCheckResult {

        /**
         * 建议，有risky、pass、review三种值
         */
        private String suggest;

        /**
         * 命中标签枚举值，
         * <pre>
         *     100 正常；10001 广告；20001 时政；20002 色情；20003 辱骂；20006 违法犯罪；
         *     20008 欺诈；20012 低俗；20013 版权；21000 其他
         * </pre>
         */
        private Integer label;
    }
}
