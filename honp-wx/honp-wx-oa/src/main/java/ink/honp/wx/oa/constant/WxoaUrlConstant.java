package ink.honp.wx.oa.constant;

import lombok.experimental.UtilityClass;

/**
 * @author jeffchen
 * date    2024/01/09 10:24
 */
@UtilityClass
public class WxoaUrlConstant {

    public static final String BASE_URL = "https://api.weixin.qq.com";

    @UtilityClass
    public class Kf {

        public static final String ADD = "";
        public static final String LIST = BASE_URL + "/cgi-bin/customservice/getkflist";
    }


    @UtilityClass
    public class Oauth2 {
        public static final String ACCESS_TOKEN = BASE_URL +
                "/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

        public static final String REFRESH_TOKEN = BASE_URL +
                "/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

        public static final String GET_USER_INFO = BASE_URL + "/sns/userinfo?access_token=%s&openid=%s&lang=%s";
    }
}
