package ink.honp.wx.miniapp.entity.response;

import lombok.Data;

/**
 * @author jeffchen
 * date    2024/01/03 17:55
 */
@Data
public class WxaUserPhoneInfo {

    /**
     * 用户绑定的手机号（国外手机号会有区号）
     */
    private String phoneNumber;

    /**
     * 没有区号的手机号
     */
    private String purePhoneNumber;

    /**
     * 区号
     */
    private String countryCode;

    /**
     * 数据水印
     */
    private Watermark watermark;

    @Data
    public static class Watermark {

        /**
         * 小程序appid
         */
        private String appid;

        /**
         * 用户获取手机号操作的时间戳
         */
        private Long timestamp;
    }
}
