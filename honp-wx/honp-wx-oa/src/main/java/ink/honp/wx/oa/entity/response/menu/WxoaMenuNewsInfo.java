package ink.honp.wx.oa.entity.response.menu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/09 15:51
 */
@Data
public class WxoaMenuNewsInfo {

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 摘要
     */
    private String digest;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否显示封面，0为不显示，1为显示
     */
    @JsonProperty("show_cover")
    private Integer showCover;

    /**
     * 封面图片的URL
     */
    @JsonProperty("cover_url")
    private String coverUrl;

    /**
     * 正文的URL
     */
    @JsonProperty("content_url")
    private String contentUrl;

    /**
     * 原文的URL，若置空则无查看原文入口
     */
    @JsonProperty("source_url")
    private String sourceUrl;
}
