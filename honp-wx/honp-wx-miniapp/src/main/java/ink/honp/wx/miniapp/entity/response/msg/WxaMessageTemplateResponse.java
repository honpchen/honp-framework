package ink.honp.wx.miniapp.entity.response.msg;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 16:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaMessageTemplateResponse extends WxResponse {

    private List<MessageTemplate> data;

    @Data
    public static class MessageTemplate {

        /**
         * 添加至账号下的模板 id，发送小程序订阅消息时所需
         */
        private String priTmplId;

        /**
         * 模版标题
         */
        private String title;

        /**
         * 模版内容
         */
        private String content;

        /**
         * 模版内容示例
         */
        private String example;

        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        private Integer type;

        /**
         * 枚举参数值范围
         */
        private List<KeyWordEnum> keywordEnumValueList;
    }

    @Data
    public static class KeyWordEnum {

        /**
         * 枚举参数的 key
         */
        private String keywordCode;

        /**
         * 枚举参数值范围列表
         */
        private List<String> keywordValueList;
    }
}
