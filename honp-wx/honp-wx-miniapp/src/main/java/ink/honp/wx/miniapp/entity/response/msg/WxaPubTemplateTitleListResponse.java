package ink.honp.wx.miniapp.entity.response.msg;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 15:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaPubTemplateTitleListResponse extends WxResponse {

    private List<PubTemplateTitle> data;

    @Data
    public static class PubTemplateTitle {

        /**
         * 模版标题 id
         */
        private Long tid;

        /**
         * 模版标题
         */
        private String title;

        /**
         * 模版类型，2 为一次性订阅，3 为长期订阅
         */
        private Integer type;

        /**
         * 模版所属类目 id
         */
        private Long categoryId;
    }
}
