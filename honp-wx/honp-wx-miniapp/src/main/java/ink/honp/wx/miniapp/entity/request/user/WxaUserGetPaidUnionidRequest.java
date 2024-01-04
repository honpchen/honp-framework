package ink.honp.wx.miniapp.entity.request.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/03 17:51
 */
@Data
@Accessors(chain = true)
public class WxaUserGetPaidUnionidRequest implements WxRequest {

    /**
     * 支付用户唯一标识，必填
     */
    private String openid;

    /**
     * 微信支付订单号
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * 微信支付分配的商户号，和商户订单号配合使用
     */
    @JsonProperty("mch_id")
    private String mchId;

    /**
     * 微信支付商户订单号，和商户号配合使用
     */
    @JsonProperty("out_trade_no")
    private String outTradeNo;
}
