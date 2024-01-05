package ink.honp.wx.miniapp.entity.request.broadcast;

import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 10:09
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastRoomCreateRequest implements WxRequest {

    /**
     * 直播间名字，最短3个汉字，最长17个汉字，1个汉字相当于2个字符
     * 必填
     */
    private String name;

    /**
     * 背景图，填入mediaID（mediaID获取后，三天内有效）；
     * 必填
     */
    private String coverImg;

    /**
     * 直播计划开始时间（开播时间需要在当前时间的10分钟后 并且 开始时间不能在 6 个月后）
     * 必填
     */
    private Long startTime;

    /**
     * 直播计划结束时间（开播时间和结束时间间隔不得短于30分钟，不得超过24小时）
     * 必填
     */
    private Long endTime;

    /**
     * 主播昵称，最短2个汉字，最长15个汉字，1个汉字相当于2个字符
     * 必填
     */
    private String anchorName;

    /**
     * 主播微信号，如果未实名认证，需要先前往“小程序直播”小程序进行实名验证,
     * 必填
     */
    private String anchorWechat;

    /**
     * 主播副号微信号，如果未实名认证，需要先前往“小程序直播”小程序进行实名验证,
     */
    private String subAnchorWechat;

    /**
     * 创建者微信号，不传入则此直播间所有成员可见。传入则此房间仅创建者、管理员、超管、直播间主播可见
     */
    private String createrWechat;

    /**
     * 分享图，填入mediaID（mediaID获取后，三天内有效）；图片mediaID的获取，
     * 必填
     */
    private String shareImg;

    /**
     * 购物直播频道封面图，填入mediaID（mediaID获取后，三天内有效）
     * 必填
     */
    private String feedsImg;

    /**
     * 是否开启官方收录 【1: 开启，0：关闭】，默认开启收录
     */
    private Integer isFeedsPublic;

    /**
     * 直播间类型 【1: 推流，0：手机直播】
     * 必填
     */
    private Integer type;

    /**
     * 是否关闭点赞 【0：开启，1：关闭】（若关闭，观众端将隐藏点赞按钮，直播开始后不允许开启）
     * 必填
     */
    private Integer closeLike;

    /**
     * 是否关闭货架 【0：开启，1：关闭】（若关闭，观众端将隐藏商品货架，直播开始后不允许开启）
     * 必填
     */
    private Integer closeGoods;

    /**
     * 是否关闭评论 【0：开启，1：关闭】（若关闭，观众端将隐藏评论按钮，直播开始后不允许开启）
     * 必填
     */
    private Integer closeComment;

    /**
     * 是否关闭回放 【0：开启，1：关闭】默认关闭回放（直播开始后允许开启）
     */
    private Integer closeReplay;

    /**
     * 是否关闭分享 【0：开启，1：关闭】默认开启分享（直播开始后不允许修改）
     */
    private Integer closeShare;

    /**
     * 是否关闭客服 【0：开启，1：关闭】 默认关闭客服（直播开始后允许开启）
     */
    private Integer closeKf;

}
