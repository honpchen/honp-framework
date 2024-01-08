package ink.honp.wx.miniapp.entity.response.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/05 10:41
 */
@Data
public class WxaBroadcastGood {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品封面图链接
     */
    @JsonProperty("cover_img")
    private String coverImg;

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
     * 商品id
     */
    @JsonProperty("goods_id")
    private Integer goodsId;

    /**
     * 第三方商品appid,当前小程序商品则为空
     */
    @JsonProperty("third_party_appid")
    private String thirdPartyAppid;

}
