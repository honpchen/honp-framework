package ink.honp.wx.miniapp.entity.response;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 14:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaListResponse extends WxResponse {

    /**
     * 总数
     */
    private Long total;
}
