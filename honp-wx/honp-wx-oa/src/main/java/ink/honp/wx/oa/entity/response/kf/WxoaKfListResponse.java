package ink.honp.wx.oa.entity.response.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.wx.core.entity.response.WxResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/09 16:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxoaKfListResponse extends WxResponse {

    @JsonProperty("kf_list")
    private List<WxoaKfAccount> kfList;

    @Data
    public static class WxoaKfAccount {

        /**
         * 客服工号
         */
        @JsonProperty("kf_id")
        private String kfId;

        /**
         * 客服昵称
         */
        @JsonProperty("kf_nick")
        private String kfNick;

        /**
         * 完整客服账号，格式为：账号前缀@公众号微信号
         */
        @JsonProperty("kf_account")
        private String kfAccount;

        /**
         * 客服头像
         */
        @JsonProperty("kf_headimgurl")
        private String kfHeadimgurl;
    }
}
