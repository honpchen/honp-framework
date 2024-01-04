package ink.honp.wx.miniapp.entity.response.user;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/03 17:36
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaUserOpenIdResponse extends WxResponse {

    /**
     * 用户的唯一标识
     */
    private String openid;
}
