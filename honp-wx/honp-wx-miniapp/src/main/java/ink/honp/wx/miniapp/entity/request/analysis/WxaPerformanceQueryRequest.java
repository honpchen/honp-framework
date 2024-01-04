package ink.honp.wx.miniapp.entity.request.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 18:27
 */
@Data
public class WxaPerformanceQueryRequest implements WxRequest {

    /**
     * 查询数据的类型,必填
     */
    private Integer module;

    /**
     * 开始和结束日期的时间戳，时间跨度不能超过30天,必填
     */
    private TimeRange time;

    /**
     * 查询条件，比如机型，网络类型等等,必填
     */
    private List<PerformanceParam> params;

    @Data
    public static class TimeRange {

        /**
         * 开始时间戳,必填
         */
        @JsonProperty("begin_timestamp")
        private Long beginTimestamp;

        /**
         * 结束时间戳,必填
         */
        @JsonProperty("end_timestamp")
        private Long endTimestamp;
     }

     @Data
     public static class PerformanceParam {

         /**
          * 查询条件
          */
        private String field;

         /**
          * 查询条件
          */
        private String value;
     }
}
