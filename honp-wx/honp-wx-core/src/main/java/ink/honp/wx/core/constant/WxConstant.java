package ink.honp.wx.core.constant;

import lombok.experimental.UtilityClass;

/**
 * @author jeff chen
 * @since 2024-01-01 23:02
 */
@UtilityClass
public class WxConstant {

    public static final int SUCCESS_CODE = 0;

    public static final String ERR_CODE = "errcode";
    public static final String ERR_MSG = "errmsg";
    public static final String ACCESS_TOKEN = "access_token";

    public interface Lang {
        String ZH_CN = "zh_CN";
        String ZH_HK = "zh_HK";
        String ZH_TW = "zh_TW";
        String EN_US = "en_US";
    }

}
