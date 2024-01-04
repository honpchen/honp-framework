package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 11:39
 */
@Data
@Accessors(chain = true)
public class WxaUrlLinkQueryRequest implements WxRequest {

    /**
     * 小程序加密 url_link。
     */
    @JsonProperty("url_link")
    private String urlLink;

    /**
     * 查询类型。默认值0，查询 url_link 信息：0， 查询每天剩余访问次数：1
     */
    @JsonProperty("query_type")
    private Integer queryType;
}
