package ink.honp.wx.miniapp.entity.request.sec;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/04 17:03
 */
@Data
public class WxaSecCheckRequest implements WxRequest {

    /**
     * 接口版本号，2.0版本为固定值2
     * 必填
     */
    private Integer version;

    /**
     * 场景值，1-资料，2-评论，3-论坛，4-社交日志
     * 必填
     */
    private Integer scene;

    /**
     * 用户的openid（用户需在近两小时访问过小程序）
     * 必填
     */
    private String openid;
}
