package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 11:44
 */
@Data
@Accessors(chain = true)
public class WxaShortLinkGenerateRequest implements WxRequest {

    /**
     * 通过 Short Link 进入的小程序页面路径，必须是已经发布的小程序存在的页面，可携带 query，最大1024个字符
     * 必填
     */
    @JsonProperty("page_url")
    private String pageUrl;

    /**
     * 页面标题，不能包含违法信息，超过20字符会用... 截断代替
     */
    @JsonProperty("page_title")
    private String pageTitle;

    /**
     * 默认值false。生成的 Short Link 类型，短期有效：false，永久有效：true
     */
    @JsonProperty("is_permanent")
    private Boolean isPermanent;
}
