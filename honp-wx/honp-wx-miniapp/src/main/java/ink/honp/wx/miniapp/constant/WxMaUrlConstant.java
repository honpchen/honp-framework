package ink.honp.wx.miniapp.constant;

import ink.honp.wx.core.constant.WxUrlConstant;
import lombok.experimental.UtilityClass;

/**
 * @author jeffchen
 * date    2024/01/02 11:42
 */
@UtilityClass
public class WxMaUrlConstant extends WxUrlConstant {

    public static final String STABLE_TOKEN = API_BASE_URL + "/cgi-bin/stable_token";

    /**
     * 小程序登录相关 API
     */
    public interface Login {
        String CODE_2_SESSION = API_BASE_URL + "/sns/jscode2session";
    }

    /**
     * 小程序用户相关 API
     */
    public interface User {
        String GET_PLUGIN_OPEN_PID = API_BASE_URL + "/wxa/getpluginopenpid";
        String GET_PAID_UNIONID = API_BASE_URL + "/wxa/getpaidunionid";
        String GET_PHONE_NUMBER = API_BASE_URL + "/wxa/business/getuserphonenumber";
    }

    /**
     * 小程序码相关 API
     */
    public interface Qrcode {

        String GET_QRCODE = "/wxa/getwxacode";
        String GET_UNLIMITED_QRCODE = "/wxa/getwxacodeunlimit";
        String CREATE_QRCODE = API_BASE_URL + "/cgi-bin/wxaapp/createwxaqrcode";
    }
}
