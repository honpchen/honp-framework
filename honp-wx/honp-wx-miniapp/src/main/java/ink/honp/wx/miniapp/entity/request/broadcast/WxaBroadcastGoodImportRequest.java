package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 10:58
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastGoodImportRequest implements WxRequest {

    /**
     * 房间ID
     * 必填
     */
    private Long roomId;

    /**
     * 数组列表，可传入多个，里面填写 商品 ID
     * 必填
     */
    private List<Long> ids;
}
