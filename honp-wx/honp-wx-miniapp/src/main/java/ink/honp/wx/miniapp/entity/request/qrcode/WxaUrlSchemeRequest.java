package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 9:48
 */
@Data
public class WxaUrlSchemeRequest implements WxRequest {

    /**
     * 跳转小程序
     */
    @JsonProperty("jump_wxa")
    private JumpWxa jumpWxa;

    @Data
    @Accessors(chain = true)
    public static class JumpWxa {

        /**
         * 通过 scheme 码进入的小程序页面路径，必须是已经发布的小程序存在的页面，
         * 不可携带 query。path 为空时会跳转小程序主页
         */
        private String path;

        /**
         * 通过 scheme 码进入小程序时的 query，最大1024个字符，
         * 只支持数字，大小写英文以及部分特殊字符：`!#$&'()*+,/:;=?@-._~%``
         */
        private String query;

        /**
         * 要打开的小程序版本。正式版为"release"，体验版为"trial"，开发版为"develop"，仅在微信外打开时生效
         */
        private String envVersion;
    }
}
