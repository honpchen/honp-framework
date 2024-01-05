package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 13:45
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastGoodsAddResponse extends WxResponse {

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 审核ID
     */
    private Long auditId;
}
