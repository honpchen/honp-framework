package ink.honp.wx.miniapp.entity.response.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 13:49
 */
@SuppressWarnings("all")
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastGoodsAuditInfoResponse extends WxResponse {


    private List<WxaBroadcastGoodAuditInfo> goods;

    /**
     * 商品总数
     */
    private Long total;


    @Data
    public static class WxaBroadcastGoodAuditInfo {

        /**
         * 商品id
         */
        private Long goodsId;

        /**
         * 商品名称
         */
        private String name;

        /**
         * 商品图片url
         */
        @JsonProperty("cover_img_url")
        private String coverImgUrl;

        /**
         * 商品小程序路径
         */
        private String url;

        /**
         * 商品价格（分）
         */
        private Long price;

        /**
         * 商品价格，使用方式看price_type
         */
        private Long price2;

        /**
         * 价格类型，
         * <pre>
         *      1：一口价（只需要传入price，price2不传）
         *      2：价格区间（price字段为左边界，price2字段为右边界，price和price2必传）
         *      3：显示折扣价（price字段为原价，price2字段为现价， price和price2必传）
         * </pre>
         */
        @JsonProperty("price_type")
        private Integer priceType;

        /**
         * 第三方商品appid,当前小程序商品则为空
         */
        @JsonProperty("third_party_appid")
        private String thirdPartyAppid;


        /**
         * 审核状态
         * <pre>
         *      0：未审核
         *      1：审核中
         *      2：审核通过
         *      3: 审核失败
         * </pre>
         */
        @JsonProperty("audit_status")
        private Integer auditStatus;

        /**
         * 1、2：表示是为 API 添加商品，否则是直播控制台添加的商品
         */
        @JsonProperty("third_party_tag")
        private Integer thirdPartyTag;
    }



}
