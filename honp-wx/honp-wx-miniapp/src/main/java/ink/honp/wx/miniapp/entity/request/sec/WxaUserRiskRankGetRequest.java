package ink.honp.wx.miniapp.entity.request.sec;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author jeffchen
 * date    2024/01/04 17:28
 */
@Data
@Accessors(chain = true)
public class WxaUserRiskRankGetRequest implements WxRequest {

    /**
     * 小程序appid，必填
     */
    private String appid;

    /**
     * 用户的openid，必填
     */
    private String openid;

    /**
     * 场景值，0:注册，1:营销作弊， 必填
     */
    private Integer scene;

    /**
     * 用户手机号
     */
    @JsonProperty("mobile_no")
    private String mobileNo;

    /**
     * 用户访问源ip，必填
     */
    @JsonProperty("client_ip")
    private String clientIp;

    /**
     * 用户邮箱地址
     */
    @JsonProperty("email_address")
    private String emailAddress;

    /**
     * 额外补充信息
     */
    @JsonProperty("extended_info")
    private String extendedInfo;

    /**
     * 默认值false。false：正式调用，true：测试调用
     */
    @JsonProperty("is_test")
    private boolean isTest;
}
