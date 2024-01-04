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
public class WxaAnalysisUserPortraitResponse extends WxResponse {

    /**
     * 时间
     */
    @JsonProperty("ref_date")
    private String refDate;

    /**
     * 新用户画像
     */
    @JsonProperty("visit_uv_new")
    private UserPortrait visitUvNew;

    /**
     * 活跃用户画像
     */
    @JsonProperty("visit_uv")
    private UserPortrait visitUv;


    @Data
    public static class UserPortrait {

        /**
         * 省份，如北京、广东等
         */
        private List<PortraitAttribute> province;

        /**
         * 城市，如北京、广州等
         */
        private List<PortraitAttribute> city;

        /**
         * 性别，包括男、女、未知
         */
        private List<PortraitAttribute> genders;

        /**
         *  终端类型，包括 iPhone，android，其他
         */
        private List<PortraitAttribute> platforms;

        /**
         * 设备
         */
        private List<PortraitAttribute> devices;

        /**
         * 年龄，包括17岁以下、18-24岁等区间
         */
        private List<PortraitAttribute> ages;
     }


    @Data
    public static class PortraitAttribute {

        /**
         * 属性值 id
         */
        private Integer id;

        /**
         * 属性值名称，与id对应。属性值为province、 city、 genders 、 platforms、devices 、 ages
         */
        private String name;

        /**
         * 该场景访问uv
         */
        private Long value;
    }
}
