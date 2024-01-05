package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 14:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoleAddResponse extends WxResponse {

    /**
     * 如果主播未实名认证，需要先前往“小程序直播”小程序进行实名验证,
     */
    private String codeurl;
}
