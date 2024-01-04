package ink.honp.wx.miniapp.entity.request.msg;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 16:23
 */
@Data
@Accessors(chain = true)
public class WxaMessageTemplateAddRequest implements WxRequest {

    /**
     * 模板标题 id，可通过接口获取，也可登录小程序后台查看获取， 必填
     */
    private String tid;

    /**
     * 开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如 [3,5,4] 或 [4,5,3]），
     * 最多支持5个，最少2个关键词组合。若为新的一次性订阅消息模板（tid >= 10000001 && tid < 20000000），则该项需传空数组
     * 必填
     */
    private String kidList;

    /**
     * 服务场景描述，15个字以内
     */
    private String sceneDesc;
}
