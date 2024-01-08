package ink.honp.wx.miniapp.entity.request.msg;

import ink.honp.wx.core.entity.request.WxPageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 16:00
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaPubTemplateTitlePageRequest extends WxPageRequest {

    /**
     * 类目 id，多个用逗号隔开
     */
    private String ids;
}
