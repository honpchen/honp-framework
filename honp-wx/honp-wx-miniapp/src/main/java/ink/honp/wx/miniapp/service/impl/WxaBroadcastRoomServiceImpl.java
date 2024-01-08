package ink.honp.wx.miniapp.service.impl;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.core.constant.WxConstant;
import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.broadcast.*;
import ink.honp.wx.miniapp.entity.response.broadcast.*;
import ink.honp.wx.miniapp.service.WxaBroadcastRoomService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/08 14:44
 */
public class WxaBroadcastRoomServiceImpl implements WxaBroadcastRoomService {

    private static final String GOODS_ID = "goodsId";
    private static final String ROOM_ID = "roomId";
    private static final String USERNAME = "username";

    private final WxaClient wxaClient;

    public WxaBroadcastRoomServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaBroadcastRoomCreateResponse createRoom(WxaBroadcastRoomCreateRequest roomCreateRequest) {

        return wxaClient.post(WxaUrlConstant.BroadcastRoom.CREATE_ROOM,
                roomCreateRequest, WxaBroadcastRoomCreateResponse.class);
    }

    @Override
    public void editRoom(WxaBroadcastRoomEditRequest roomEditRequest) {

       wxaClient.post(WxaUrlConstant.BroadcastRoom.EDIT_ROOM, roomEditRequest);
    }

    @Override
    public void deleteRoom(Long roomId) {
        Map<String, Long> roomIdMap = CollectionUtil.newHashMap();
        roomIdMap.put(WxConstant.ID, roomId);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.DELETE_ROOM, roomIdMap);
    }

    @Override
    public WxaBroadcastLiveListResponse getLiveInfo(WxaBroadcastLiveInfoQueryRequest liveInfoQueryRequest) {

        return wxaClient.post(WxaUrlConstant.BroadcastRoom.GET_LIVE_INFO,
                liveInfoQueryRequest, WxaBroadcastLiveListResponse.class);
    }

    @Override
    public void importGoods(WxaBroadcastGoodImportRequest importRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.IMPORT_GOODS, importRequest);
    }

    @Override
    public void pushGoods(Long roomId, Long goodsId) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.PUSH_GOODS, goodsIdQuery(roomId, goodsId));
    }

    @Override
    public void saleGoods(Long roomId, Long goodsId, Integer onSale) {

        Map<String, Object> queryParams = goodsIdQuery(roomId, goodsId);
        queryParams.put("onSale", onSale);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.MODIFY_GOODS_SALE, queryParams);
    }

    @Override
    public void deleteGoods(Long roomId, Long goodsId) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.DELETE_GOODS, goodsIdQuery(roomId, goodsId));
    }

    @Override
    public void sortGoods(WxaBroadcastGoodsSortRequest sortRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.GOODS_SORT, sortRequest);
    }

    @Override
    public String getPushUrl(Long roomId) {

        String content =  wxaClient.get(String.format(WxaUrlConstant.BroadcastRoom.GET_PUSH_URL, roomId), null);

        return WxResponseParseUtil.parse(content, "pushAddr");
    }

    @Override
    public WxaBroadcastRoomShareCodeResponse getShareCode(Long roomId, String params) {
        Map<String, Object> queryParams = CollectionUtil.newHashMap();
        queryParams.put(ROOM_ID, roomId);
        if (StringUtils.isNotBlank(params)) {
            queryParams.put("params", params);
        }

        return wxaClient.get(WxaUrlConstant.BroadcastRoom.GET_SHARE_CODE,
                queryParams, WxaBroadcastRoomShareCodeResponse.class);
    }

    @Override
    public String getSubAnchor(Long roomId) {

        String content = wxaClient.get(String.format(WxaUrlConstant.BroadcastRoom.GET_SUB_ANCHOR, roomId), null);

        return WxResponseParseUtil.parse(content, USERNAME);
    }

    @Override
    public void addSubAnchor(WxaBroadcastRoomSubAnchorRequest subAnchorAddRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.ADD_SUB_ANCHOR, subAnchorAddRequest);
    }

    @Override
    public void modifySubAnchor(WxaBroadcastRoomSubAnchorRequest subAnchorModifyRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.MODIFY_SUB_ANCHOR, subAnchorModifyRequest);
    }

    @Override
    public void deleteSubAnchor(Long roomId) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.DELETE_SUB_ANCHOR, roomQuery(roomId));
    }

    @Override
    public WxaBroadcastAssistantListResponse getAssistantList(Long roomId) {

        String url = String.format(WxaUrlConstant.BroadcastRoom.GET_ASSISTANT_LIST, roomId);

        return wxaClient.get(url, null, WxaBroadcastAssistantListResponse.class);
    }

    @Override
    public void addAssistant(WxaBroadcastAssistantAddRequest assistantAddRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.ADD_ASSISTANT, assistantAddRequest);
    }

    @Override
    public void modifyAssistant(WxaBroadcastAssistantModifyRequest assistantModifyRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastRoom.MODIFY_ASSISTANT, assistantModifyRequest);
    }

    @Override
    public void removeAssistant(Long roomId, String username) {
        Map<String, Object> queryParams = roomQuery(roomId);
        queryParams.put(USERNAME, username);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.REMOVE_ASSISTANT, queryParams);
    }

    @Override
    public void updateComment(Long roomId, Integer banComment) {
        Map<String, Object> queryParams = CollectionUtil.newHashMap();
        queryParams.put(WxConstant.ID, roomId);
        queryParams.put("banComment", banComment);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.UPDATE_COMMENT, queryParams);
    }

    @Override
    public void updateFeedPublic(Long roomId, Integer isFeedsPublic) {
        Map<String, Object> queryParams = roomQuery(roomId);
        queryParams.put("isFeedsPublic", isFeedsPublic);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.UPDATE_FEED_PUBLIC, queryParams);
    }

    @Override
    public void updateKf(Long roomId, Integer closeKf) {
        Map<String, Object> queryParams = roomQuery(roomId);
        queryParams.put("closeKf", closeKf);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.UPDATE_KF, queryParams);
    }

    @Override
    public void updateReplay(Long roomId, Integer closeReplay) {
        Map<String, Object> queryParams = roomQuery(roomId);
        queryParams.put("closeReplay", closeReplay);

        wxaClient.post(WxaUrlConstant.BroadcastRoom.UPDATE_REPLAY, queryParams);
    }

    @Override
    public String downloadGoodsVideo(Long roomId, Long goodId) {
        String content = wxaClient.post(WxaUrlConstant.BroadcastRoom.DOWNLOAD_GOODS_VIDEO, goodsIdQuery(roomId, goodId));

        return WxResponseParseUtil.parse(content, "url");
    }

    private Map<String, Object> goodsIdQuery(Long roomId, Long goodsId) {
        Map<String, Object> goodsIdQuery = CollectionUtil.newHashMap();
        goodsIdQuery.put(ROOM_ID, roomId);
        goodsIdQuery.put(GOODS_ID, goodsId);
        return goodsIdQuery;
    }

    private Map<String, Object> roomQuery(Long roomId) {
        Map<String, Object> roomQuery = CollectionUtil.newHashMap();
        roomQuery.put(ROOM_ID, roomId);
        return roomQuery;
    }
}
