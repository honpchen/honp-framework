package ink.honp.wx.miniapp.entity.response.msg;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 16:27
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaMessageTemplateIdResponse extends WxResponse {

    /**
     * 添加至账号下的模板id，发送小程序订阅消息时所需
     */
    private String priTmplId;
}
