package ink.honp.wx.miniapp.entity.response.qrcode;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 9:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaImageBufferResponse extends WxResponse {

    private byte[] bytes;
}
