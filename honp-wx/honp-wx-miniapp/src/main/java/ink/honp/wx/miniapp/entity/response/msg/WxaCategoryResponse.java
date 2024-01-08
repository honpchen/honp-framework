package ink.honp.wx.miniapp.entity.response.msg;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/04 15:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaCategoryResponse extends WxResponse {

    private List<WxaCategory> data;

    @Data
    public static class WxaCategory {

        /**
         * 类目 id
         */
        private Long id;

        /**
         * 类目的中文名
         */
        private String name;
    }
}
