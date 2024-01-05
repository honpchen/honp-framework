package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/05 11:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoomShareCodeResponse extends WxResponse {

    /**
     * 分享二维码cdn url
     */
    private String cdnUrl;

    /**
     * 分享路径
     */
    private String pagePath;

    /**
     * 分享海报 url
     */
    private String posterUrl;
}
