package ink.honp.wx.miniapp.entity.request.msg;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 16:00
 */
@Data
@Accessors(chain = true)
public class WxaPubTemplateTitleListGetRequest implements WxRequest {

    /**
     * 类目 id，多个用逗号隔开
     */
    private String ids;

    /**
     * 用于分页，表示从 start 开始。从 0 开始计数
     */
    private Integer start;

    /**
     * 用于分页，表示拉取 limit 条记录。最大为 30
     */
    private Integer limit;
}
