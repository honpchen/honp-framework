package ink.honp.wx.cgi.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 10:06
 */
@Data
@Accessors(chain = true)
public class WxStableAccessTokenGetRequest implements WxRequest {

    private String appid;

    private String secret;

    @JsonProperty("grant_type")
    private String grantType;

    /**
     * 默认使用 false。
     * <pre>
     *      1. force_refresh = false 时为普通调用模式，access_token 有效期内重复调用该接口不会更新 access_token
     *      2. 当force_refresh = true 时为强制刷新模式，会导致上次获取的 access_token 失效，并返回新的 access_token
     * </pre>
     */
    @JsonProperty("force_refresh")
    private Boolean forceRefresh;
}
