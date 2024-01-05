package ink.honp.wx.miniapp.entity.request.broadcast;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/05 13:59
 */
@Data
@Accessors(chain = true)
public class WxaBroadcastGoodsInfoRequest implements WxRequest {

    /**
     * 商品ID，更新时必填
     */
    private Long goodsId;

    /**
     * 商品名称，最长14个汉字，1个汉字相当于2个字符，必填
     */
    private String name;

    /**
     * 填入mediaID（mediaID获取后，三天内有效），必填
     */
    private String coverImgUrl;

    /**
     * 商品详情页的小程序路径，路径参数存在 url 的，该参数的值需要进行 encode 处理再填入
     */
    private String url;

    /**
     * 数字，最多保留两位小数，单位元，必填
     */
    private Double price;

    /**
     * 数字，最多保留两位小数，单位元
     */
    private Double price2;

    /**
     * 价格类型，必填
     * <pre>
     *      1：一口价（只需要传入price，price2不传）
     *      2：价格区间（price字段为左边界，price2字段为右边界，price和price2必传）
     *      3：显示折扣价（price字段为原价，price2字段为现价， price和price2必传）
     * </pre>
     */
    @JsonProperty("price_type")
    private Integer priceType;

    /**
     * 当商品为第三方小程序的商品则填写为对应第三方小程序的appid，自身小程序商品则为''
     */
    @JsonProperty("third_party_appid")
    private String thirdPartyAppid;
}
