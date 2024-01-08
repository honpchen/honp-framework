package ink.honp.wx.miniapp.entity.response.msg;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 15:51
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaPubTemplateKeyWordResponse extends WxResponse {

    private List<WxaPubTemplateKeyWord> data;

    @Data
    public static class WxaPubTemplateKeyWord {
        /**
         * 关键词 id，选用模板时需要
         */
        private Long kid;

        /**
         * 关键词内容
         */
        private String name;

        /**
         * 关键词内容对应的示例
         */
        private String example;

        /**
         * 参数类型
         */
        private String rule;

    }

}
