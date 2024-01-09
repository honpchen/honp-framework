package ink.honp.wx.oa.entity.response.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/09 15:43
 */
@Data
public class WxoaMenuButton {

    /**
     * 菜单的类型，公众平台官网上能够设置的菜单类型有view（跳转网页）、text（返回文本，下同）、
     * img、photo、video、voice。使用API设置的则有8种，详见《自定义菜单创建接口》
     */
    private String type;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 对于不同的菜单类型，value的值意义不同。
     * <pre>
     *     官网上设置的自定义菜单：
     *          Text:保存文字到value；
     *          Img、voice：保存mediaID到value；
     *          Video：保存视频下载链接到value；
     *          News：保存图文消息到news_info，同时保存mediaID到value；
     *          View：保存链接到url。
     *     使用API设置的自定义菜单：
     *          click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、 pic_weixin、location_select：保存值到key；
     *          view：保存链接到url
     * </pre>
     */
    private String value;

    private String url;

    private String key;

    @JsonProperty("news_info")
    private WxoaMenuButtonNewsInfo newsInfo;


    @Data
    public static class WxoaMenuButtonNewsInfo {

        private List<WxoaMenuNewsInfo> list;
    }
}
