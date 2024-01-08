package ink.honp.wx.core.entity.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/08 10:35
 */
@Data
@Accessors(chain = true)
public class WxPageRequest implements WxRequest {

    private Integer start;

    private Integer limit;
}
