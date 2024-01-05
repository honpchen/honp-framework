package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastGoodsAddRequest;
import ink.honp.wx.miniapp.entity.request.broadcast.WxaBroadcastGoodsUpdateRequest;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastGoodsAddResponse;
import ink.honp.wx.miniapp.entity.response.broadcast.WxaBroadcastGoodsAuditInfoResponse;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 13:47
 */
public interface WxaBroadcastGoodsService extends WxaService {

    /**
     * 添加并提审商品
     * @param goodsAddRequest -
     * @return 返回商品 id 和 审核 id
     */
    WxaBroadcastGoodsAddResponse addGoods(WxaBroadcastGoodsAddRequest goodsAddRequest);

    /**
     * 重新提交审核
     * @param goodsId 商品 id
     * @return 返回审核 id
     */
    String resubmitAudit(Long goodsId);

    /**
     * 获取商品审核信息
     * @param goodsIds 商品 id 列表
     * @return 返回商品审核信息
     */
    WxaBroadcastGoodsAuditInfoResponse getGoodsAuditInfo(List<Long> goodsIds);

    /**
     * 撤回商品审核
     * @param goodsId 商品 id
     * @param auditId 审核 id
     */
    void resetAudit(Long goodsId, Long auditId);

    /**
     * 更新商品
     * @param goodsUpdateRequest -
     */
    void updateGoods(WxaBroadcastGoodsUpdateRequest goodsUpdateRequest);

    /**
     * 删除商品
     * @param goodsId 商品 id
     */
    void deleteGoodsInfo(Long goodsId);
}
