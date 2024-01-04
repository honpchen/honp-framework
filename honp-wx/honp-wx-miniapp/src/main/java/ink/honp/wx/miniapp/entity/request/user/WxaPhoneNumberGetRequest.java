package ink.honp.wx.miniapp.entity.request.user;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 18:00
 */
@Data
@Accessors(chain = true)
public class WxaPhoneNumberGetRequest implements WxRequest {

    /**
     * 手机号获取凭证, 必填
     */
    private String code;

    /**
     * 用户唯一标识
     */
    private String openid;
}
