package ink.honp.wx.miniapp.entity.response.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 10:40
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastLiveListResponse extends WxResponse {

    /**
     * action="get_replay"不返回
     */
    @JsonProperty("room_info")
    private List<WxaBroadcastRoomInfo> roomInfo;

    /**
     * 拉取房间总数
     */
    private Long total;


    /**
     * action="get_replay"返回
     */
    @JsonProperty("live_replay")
    private List<WxaBroadcastLiveReplay> liveReplay;

    @Data
    public static class WxaBroadcastRoomInfo {

        /**
         * 直播间名称
         */
        private String name;

        /**
         * 直播间背景图链接
         */
        private String coverImg;

        /**
         * 直播间开始时间，列表按照start_time降序排列
         */
        private Long startTime;

        /**
         * 直播计划结束时间
         */
        private Long endTime;

        /**
         * 主播名
         */
        @JsonProperty("anchor_name")
        private String anchorName;

        /**
         * 直播间ID
         */
        private Long roomId;

        /**
         * 商品信息
         */
        private List<WxaBroadcastGood> goods;

        /**
         * 直播间状态。101：直播中，102：未开始，103已结束，104禁播，105：暂停，106：异常，107：已过期
         */
        @JsonProperty("live_status")
        private Integer liveStatus;

        /**
         * 直播间分享图链接
         */
        @JsonProperty("share_img")
        private String shareImg;

        /**
         * 直播类型，1 推流 0 手机直播
         */
        @JsonProperty("live_type")
        private Integer liveType;

        /**
         * 是否关闭点赞 【0：开启，1：关闭】（若关闭，观众端将隐藏点赞按钮，直播开始后不允许开启）
         */
        @JsonProperty("close_like")
        private Integer closeLike;

        /**
         * 是否关闭货架 【0：开启，1：关闭】（若关闭，观众端将隐藏商品货架，直播开始后不允许开启）
         */
        @JsonProperty("close_goods")
        private Integer closeGoods;

        /**
         * 是否关闭评论 【0：开启，1：关闭】（若关闭，观众端将隐藏评论入口，直播开始后不允许开启）
         */
        @JsonProperty("close_comment")
        private Integer closeComment;

        /**
         * 是否关闭客服 【0：开启，1：关闭】 默认关闭客服（直播开始后允许开启）
         */
        @JsonProperty("close_kf")
        private Integer closeKf;

        /**
         * 是否关闭回放 【0：开启，1：关闭】默认关闭回放（直播开始后允许开启）
         */
        @JsonProperty("close_replay")
        private Integer closeReplay;

        /**
         * 是否开启官方收录，1 开启，0 关闭
         */
        @JsonProperty("is_feeds_public")
        private Integer isFeedsPublic;

        /**
         * 创建者openid
         */
        @JsonProperty("creater_openid")
        private String createrOpenid;

        /**
         * 官方收录封面
         */
        @JsonProperty("feeds_img")
        private String feedsImg;
    }


    @Data
    public static class WxaBroadcastLiveReplay {

        /**
         * 回放视频创建时间
         */
        @JsonProperty("create_time")
        private String createTime;

        /**
         * 回放视频url过期时间
         */
        @JsonProperty("expire_time")
        private String expireTime;

        /**
         * 回放视频链接
         */
        @JsonProperty("media_url")
        private String mediaUrl;
    }
}
