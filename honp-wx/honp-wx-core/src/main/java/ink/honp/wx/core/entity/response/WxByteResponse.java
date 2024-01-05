package ink.honp.wx.core.entity.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 15:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxByteResponse extends WxResponse {

    private byte[] bytes;
}
