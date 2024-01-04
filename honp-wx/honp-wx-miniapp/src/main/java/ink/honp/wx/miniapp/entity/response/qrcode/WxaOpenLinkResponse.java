package ink.honp.wx.miniapp.entity.response.qrcode;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/03 18:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaOpenLinkResponse extends WxResponse {

    /**
     * 小程序打开链接
     */
    private String openlink;

}
