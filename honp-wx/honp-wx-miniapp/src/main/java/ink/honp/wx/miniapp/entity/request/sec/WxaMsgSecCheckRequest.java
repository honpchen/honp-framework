package ink.honp.wx.miniapp.entity.request.sec;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 17:03
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaMsgSecCheckRequest extends WxaSecCheckRequest {

    /**
     * 需检测的文本内容，文本字数的上限为2500字，需使用UTF-8编码
     * 必填
     */
    private String content;

    /**
     * 文本标题，需使用UTF-8编码
     */
    private String title;

    /**
     * 用户昵称，需使用UTF-8编码
     */
    private String nickname;

    /**
     * 个性签名，该参数仅在资料类场景有效(scene=1)，需使用UTF-8编
     */
    private String signature;
}
