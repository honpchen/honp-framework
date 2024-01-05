package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 13:38
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastGoodsAddRequest implements WxRequest {

    /**
     * 商品信息
     */
    private WxaBroadcastGoodsInfoRequest goodsInfo;
}
