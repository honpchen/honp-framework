package ink.honp.wx.miniapp.entity.request.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 14:42
 */
@Data
@Accessors(chain = true)
public class WxaActivityMessageUpdateRequest implements WxRequest {

    /**
     * 动态消息的 ID，通过 createActivityId 接口获取
     */
    @JsonProperty("activity_id")
    private String activityId;

    /**
     * 动态消息修改后的状态
     * <pre>
     *     0: 未开始
     *     1: 已开始
     * </pre>
     */
    @JsonProperty("target_state")
    private Integer targetState;

    @JsonProperty("template_info")
    private WxaMessageTemplateInfo templateInfo;

    @Data
    @Accessors(chain = true)
    public static class WxaMessageTemplateInfo {

        @JsonProperty("parameter_list")
        private List<WxaTemplateParameter> parameterList;
    }

    @Data
    @Accessors(chain = true)
    public static class WxaTemplateParameter {

        /**
         * 要修改的参数名
         * <pre>
         *     name 合法值
         *     member_count	target_state = 0 时必填，文字内容模板中 member_count 的值
         *     room_limit	target_state = 0 时必填，文字内容模板中 room_limit 的值
         *     path	        target_state = 1 时必填，点击「进入」启动小程序时使用的路径。对于小游戏，
         *                      没有页面的概念，可以用于传递查询字符串（query），如 "?foo=bar"
         *     version_type target_state = 1 时必填，点击「进入」启动小程序时使用的版本
         *                      有效参数值为：develop（开发版），trial（体验版），release（正式版）
         * </pre>
         */
        private String name;

        /**
         * 修改后的参数值
         */
        private String value;
    }

}
