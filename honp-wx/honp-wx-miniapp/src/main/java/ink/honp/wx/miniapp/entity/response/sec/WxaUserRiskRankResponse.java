package ink.honp.wx.miniapp.entity.response.sec;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jeffchen
 * date    2024/01/04 17:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaUserRiskRankResponse extends WxResponse {

    /**
     * 唯一请求标识，标记单次请求
     */
    private String unionid;

    /**
     * 用户风险等级，合法值为0,1,2,3,4，数字越大风险越高
     */
    @JsonProperty("risk_rank")
    private Integer riskRank;
}
