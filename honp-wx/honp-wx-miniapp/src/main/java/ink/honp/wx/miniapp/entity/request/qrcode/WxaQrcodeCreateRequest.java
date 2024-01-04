package ink.honp.wx.miniapp.entity.request.qrcode;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 18:24
 */
@Data
@Accessors(chain = true)
public class WxaQrcodeCreateRequest implements WxRequest {

    /**
     * <pre>
     *     扫码进入的小程序页面路径，最大长度 1024 个字符，不能为空，
     *     scancode_time为系统保留参数，不允许配置；对于小游戏，可以只传入 query 部分，来实现传参效果，
     *     如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}
     * </pre>
     */
    private String path;

    private Integer width;
}
