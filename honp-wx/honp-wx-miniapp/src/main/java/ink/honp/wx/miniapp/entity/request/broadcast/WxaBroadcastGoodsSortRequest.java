package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 11:27
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastGoodsSortRequest implements WxRequest {

    /**
     * 房间ID
     */
    private Long roomId;

    /**
     * 商品ID列表
     */
    private List<GoodsId> goods;

    @Data
    @SuppressWarnings("all")
    public static class GoodsId {

        /**
         * 商品ID
         */
        private Long goodsId;
    }
}
