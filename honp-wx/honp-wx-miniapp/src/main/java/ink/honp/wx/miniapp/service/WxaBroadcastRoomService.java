package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.broadcast.*;
import ink.honp.wx.miniapp.entity.response.broadcast.*;

/**
 * @author jeffchen
 * date    2024/01/05 10:08
 */
public interface WxaBroadcastRoomService extends WxaService {

    /**
     * 创建直播间
     * <pre>
     *     调用此接口创建直播间，创建成功后将在直播间列表展示
     * </pre>
     * @param roomCreateRequest -
     * @return 返回直播间 ID
     */
    WxaBroadcastRoomCreateResponse createRoom(WxaBroadcastRoomCreateRequest roomCreateRequest);

    /**
     * 编辑直播间
     * @param roomEditRequest -
     */
    void editRoom(WxaBroadcastRoomEditRequest roomEditRequest);

    /**
     * 删除直播间
     * @param roomId 房间ID
     */
    void deleteRoom(Long roomId);

    /**
     * 获取直播间列表和回放
     * <pre>
     *     该接口用于获取直播间列表及直播间信息。也可以用来获取已结束直播间的回放源视频（一般在直播结束后10分钟内生成，源视频无评论等内容）
     * </pre>
     * @param liveInfoQueryRequest -
     * @return 直播间列表和回放
     */
    WxaBroadcastLiveListResponse getLiveInfo(WxaBroadcastLiveInfoQueryRequest liveInfoQueryRequest);

    /**
     * 导入商品
     * @param importRequest -
     */
    void importGoods(WxaBroadcastGoodImportRequest importRequest);

    /**
     * 推送商品
     * @param roomId 房间 ID
     * @param goodId 商品 ID
     */
    void pushGoods(Long roomId, Long goodId);

    /**
     * 上下架商品
     * @param roomId 房间 ID
     * @param goodId 商品 ID
     * @param onSale 上下架 【0：下架，1：上架】
     */
    void saleGoods(Long roomId, Long goodId, Integer onSale);

    /**
     * 删除直播间商品
     * @param roomId 房间 ID
     * @param goodId 商品 ID
     */
    void deleteGoods(Long roomId, Long goodId);

    /**
     * 直播间商品排序
     * @param sortRequest -
     */
    void sortGoods(WxaBroadcastGoodsSortRequest sortRequest);

    /**
     * 获取直播间推流地址
     * @param roomId 房间ID
     * @return 推流地址
     */
    WxaBroadcastRoomPushAddressResponse getPushUrl(Long roomId);

    /**
     * 获取直播间分享二维码
     * @param roomId 房间ID
     * @return 直播间分享二维码
     */
    WxaBroadcastRoomShareCodeResponse getShareCode(Long roomId);

    /**
     * 获取主播副号
     * @param roomId 房间 ID
     * @return -
     */
    WxaBroadcastRoomSubAnchorResponse getSubAnchor(Long roomId);

    /**
     * 添加主播副号
     * @param subAnchorAddRequest -
     */
    void addSubAnchor(WxaBroadcastRoomSubAnchorRequest subAnchorAddRequest);

    /**
     * 修改主播副号
     * @param subAnchorModifyRequest -
     */
    void modifySubAnchor(WxaBroadcastRoomSubAnchorRequest subAnchorModifyRequest);

    /**
     * 删除主播副号
     * @param roomId 房间 ID
     */
    void deleteSubAnchor(Long roomId);

    /**
     * 获取直播间小助手列表
     * @param roomId 房间 ID
     * @return -
     */
    WxaBroadcastAssistantListResponse getAssistantList(Long roomId);

    /**
     * 添加直播间小助手
     * @param assistantAddRequest -
     */
    void addAssistant(WxaBroadcastAssistantAddRequest assistantAddRequest);

    /**
     * 修改直播间小助手
     * @param assistantModifyRequest -
     */
    void modifyAssistant(WxaBroadcastAssistantModifyRequest assistantModifyRequest);

    /**
     * 删除直播间小助手
     * @param roomId 房间 ID
     * @param username 微信号
     */
    void removeAssistant(Long roomId, String username);

    /**
     * 禁言管理
     * @param roomId   房间 ID
     * @param banComment 1-禁言，0-取消禁言
     */
    void updateComment(Long roomId, Integer banComment);

    /**
     * 官方收录管理
     * @param roomId   房间 ID
     * @param isFeedsPublic 是否开启官方收录 【1: 开启，0：关闭】
     */
    void updateFeedPublic(Long roomId, Integer isFeedsPublic);

    /**
     * 客服功能管理
     * @param roomId    房间 ID
     * @param closeKf 是否关闭客服 【0：开启，1：关闭】
     */
    void updateKf(Long roomId, Integer closeKf);

    /**
     * 回放管理
     * @param roomId    房间 ID
     * @param closeReplay 是否关闭回放 【0：开启，1：关闭】
     */
    void updateReplay(Long roomId, Integer closeReplay);

    /**
     * 下载商品讲解视频
     * @param roomId 房间ID
     * @param goodId 商品ID
     * @return 讲解链接
     */
    String downloadGoodsVideo(Long roomId, Long goodId);
}
