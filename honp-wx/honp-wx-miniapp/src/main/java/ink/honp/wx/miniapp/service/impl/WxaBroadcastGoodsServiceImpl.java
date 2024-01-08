package ink.honp.wx.miniapp.service.impl;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.core.util.WxResponseParseUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastGoodsAddRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastGoodsUpdateRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastGoodsAddResponse;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastGoodsAuditInfoResponse;
import ink.honp.wx.miniapp.service.WxaBroadcastGoodsService;

import java.util.List;
import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/08 16:12
 */
public class WxaBroadcastGoodsServiceImpl implements WxaBroadcastGoodsService {

    private static final String GOODS_ID = "goodsId";
    private static final String AUDIT_ID = "auditId";

    private final WxaClient wxaClient;

    public WxaBroadcastGoodsServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaBroadcastGoodsAddResponse addGoods(WxaBroadcastGoodsAddRequest goodsAddRequest) {

        return wxaClient.post(WxaUrlConstant.BroadcastGoods.ADD, goodsAddRequest, WxaBroadcastGoodsAddResponse.class);
    }

    @Override
    public String resubmitAudit(Long goodsId) {
        String response = wxaClient.post(WxaUrlConstant.BroadcastGoods.AUDIT, goodsIdQuery(goodsId));

        return WxResponseParseUtil.parse(response, AUDIT_ID);
    }

    @Override
    public WxaBroadcastGoodsAuditInfoResponse getGoodsAuditInfo(List<Long> goodsIds) {
        Map<String, Object> queryParams = CollectionUtil.newHashMap();
        queryParams.put("goods_ids", goodsIds);

        return wxaClient.post(WxaUrlConstant.BroadcastGoods.GET_GOODS_WARE_HOUSE,
                queryParams, WxaBroadcastGoodsAuditInfoResponse.class);
    }

    @Override
    public void resetAudit(Long goodsId, Long auditId) {
        Map<String, Object> queryParams = goodsIdQuery(goodsId);
        queryParams.put(AUDIT_ID, auditId);

        wxaClient.post(WxaUrlConstant.BroadcastGoods.RESET_AUDIT, queryParams);
    }

    @Override
    public void updateGoods(WxaBroadcastGoodsUpdateRequest goodsUpdateRequest) {

        wxaClient.post(WxaUrlConstant.BroadcastGoods.UPDATE, goodsUpdateRequest);
    }

    @Override
    public void deleteGoodsInfo(Long goodsId) {

        wxaClient.post(WxaUrlConstant.BroadcastGoods.DELETE, goodsIdQuery(goodsId));
    }

    private Map<String, Object> goodsIdQuery(Long goodsId) {
        Map<String, Object> query = CollectionUtil.newHashMap();
        query.put(GOODS_ID, goodsId);

        return query;
    }
}
