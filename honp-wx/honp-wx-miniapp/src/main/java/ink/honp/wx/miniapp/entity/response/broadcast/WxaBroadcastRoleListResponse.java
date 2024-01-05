package ink.honp.wx.miniapp.entity.response.broadcast;

import ink.honp.wx.miniapp.entity.response.WxaListResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author jeffchen
 * date    2024/01/05 14:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxaBroadcastRoleListResponse extends WxaListResponse {

    private List<WxaBroadcastRole> list;

    @Data
    public static class WxaBroadcastRole {
        /**
         * 微信用户头像url
         */
        private String headingimg;

        /**
         * 微信用户昵称
         */
        private String nickname;

        /**
         * openid
         */
        private String openid;

        /**
         * 具有的身份，[0-超级管理员，1-管理员，2-主播，3-运营者]
         */
        private List<Integer> roleList;

        /**
         * 更新时间
         */
        private Long updateTimestamp;

        /**
         * 微信号
         */
        private String username;
    }


}
