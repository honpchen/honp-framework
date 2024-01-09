package ink.honp.wx.oa.entity.request.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/09 15:32
 */
@Data
@Accessors(chain = true)
public class WxoaMenuButtonCreateRequest implements WxRequest {

    /**
     * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型，必填
     */
    private String type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节，必填
     */
    private String name;

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节，click等点击类型必须
     */
    private String key;

    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节，type为view时必填
     * <pre>
     *      view、miniprogram类型必须
     *      type为miniprogram时，不支持小程序的老版本客户端将打开本url。
     * </pre>
     */
    private String url;

    /**
     * 调用新增永久素材接口返回的合法media_id
     * <pre>
     *     media_id类型和view_limited类型必须
     * </pre>
     */
    @JsonProperty("media_id")
    private String mediaId;

    /**
     * 小程序的appid（仅认证公众号可配置）
     * <pre>
     *     miniprogram类型必须
     * </pre>
     */
    private String appid;

    /**
     * 小程序的页面路径
     * <pre>
     *     miniprogram类型必须
     * </pre>
     */
    private String pagepath;

    /**
     * 图文消息的封面图片素材id（必须是永久mediaID）
     */
    @JsonProperty("article_id")
    private String articleId;

    /**
     * 二级菜单数组，个数应为1~5个
     */
    @JsonProperty("sub_button")
    public List<WxoaMenuButtonCreateRequest> subButtons;
}
