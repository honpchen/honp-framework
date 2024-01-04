package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 11:20
 */
@Data
@Accessors(chain = true)
public class WxaUrlLinkGenerateRequest implements WxRequest {

    /**
     * 通过 URL Link 进入的小程序页面路径，必须是已经发布的小程序存在的页面，不可携带 query 。path 为空时会跳转小程序主页
     */
    private String path;

    /**
     * 通过 URL Link 进入小程序时的query，最大1024个字符，只支持数字，大小写英文以及部分特殊字符：!#$&'()*+,/:;=?@-._~%
     */
    private String query;

    /**
     * 默认值0.小程序 URL Link 失效类型，失效时间：0，失效间隔天数：1
     */
    @JsonProperty("expire_type")
    private Integer expireType;

    /**
     * 到期失效的 URL Link 的失效时间，为 Unix 时间戳。生成的到期失效 URL Link 在该时间前有效。最长有效期为30天。expire_type 为 0 必填
     */
    @JsonProperty("expire_time")
    private Long expireTime;

    /**
     * 到期失效的URL Link的失效间隔天数。生成的到期失效URL Link在该间隔时间到达前有效。最长间隔天数为30天。expire_type 为 1 必填
     */
    @JsonProperty("expire_interval")
    private Integer expireInterval;

    /**
     * 默认值"release"。要打开的小程序版本。正式版为 "release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效
     */
    @JsonProperty("env_version")
    private String envVersion;
}
