package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/05 14:00
 */
@Data
public class WxaBroadcastGoodsUpdateRequest implements WxRequest {

    /**
     * 商品信息
     */
    private WxaBroadcastGoodsInfoRequest goodsInfo;
}
