package ink.honp.wx.miniapp.entity.request.sec;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 17:21
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class WxaMediaCheckAsyncRequest extends WxaSecCheckRequest {

    /**
     * 要检测的图片或音频的url，支持图片格式包括jpg, jepg, png, bmp, gif（取首帧），
     * 支持的音频格式包括mp3, aac, ac3, wma, flac, vorbis, opus, wav
     * 必填
     */
    @JsonProperty("media_url")
    private String mediaUrl;

    /**
     * 1:音频;2:图片
     * 必填
     */
    @JsonProperty("media_type")
    private Integer mediaType;
}
