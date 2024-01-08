package ink.honp.wx.miniapp.entity.request.broadcast;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 10:58
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastGoodImportRequest extends WxaBroadRoomIdRequest {

    /**
     * 数组列表，可传入多个，里面填写 商品 ID
     * 必填
     */
    private List<Long> ids;
}
