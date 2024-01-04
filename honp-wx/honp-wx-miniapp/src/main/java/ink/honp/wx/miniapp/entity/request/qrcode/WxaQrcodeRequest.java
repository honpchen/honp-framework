package ink.honp.wx.miniapp.entity.request.qrcode;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 18:06
 */
@Data
public class WxaQrcodeRequest implements WxRequest {

    /**
     * 二维码的宽度，单位：px。最小 280px，最大 1280px
     */
    private Integer width;

    @JsonProperty("auto_color")
    private boolean autoColor;

    /**
     * 自动颜色，如果颜色依然是黑色，则说明不建议配置主色调，默认 false
     */
    @JsonProperty("line_color")
    private LineColor lineColor;

    /**
     * 是否需要透明底色，为 true 时，生成透明底色的小程序码
     */
    @JsonProperty("is_hyaline")
    private boolean isHyaline;

    /**
     * 要打开的小程序版本。正式版为 "release"，体验版为 "trial"，开发版为 "develop"。默认是正式版。
     */
    @JsonProperty("env_version")
    private String envVersion;

    @Data
    @Accessors(chain = true)
    public static class LineColor {
        private int r;
        private int g;
        private int b;

    }
}
