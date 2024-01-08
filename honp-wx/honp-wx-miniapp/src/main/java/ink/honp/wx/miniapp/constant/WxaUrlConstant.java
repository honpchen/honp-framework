package ink.honp.wx.miniapp.constant;

import ink.honp.wx.core.constant.WxUrlConstant;
import lombok.experimental.UtilityClass;

/**
 * @author jeffchen
 * date    2024/01/02 11:42
 */
@UtilityClass
public class WxaUrlConstant extends WxUrlConstant {

    public static final String STABLE_TOKEN = API_BASE_URL + "/cgi-bin/stable_token";

    /**
     * 小程序登录相关 API
     */
    @UtilityClass
    public class Login {
        public static final String CODE_2_SESSION = API_BASE_URL + "/sns/jscode2session?appid=%s&secret=%s&js_code=%s&=grant_type=authorization_code";
    }

    /**
     * 小程序用户相关 API
     */
    @UtilityClass
    public class User {
        public static final String GET_PLUGIN_OPEN_PID = API_BASE_URL + "/wxa/getpluginopenpid";
        public static final String GET_PAID_UNIONID = API_BASE_URL + "/wxa/getpaidunionid";
        public static final String GET_PHONE_NUMBER = API_BASE_URL + "/wxa/business/getuserphonenumber";
    }

    /**
     * 小程序码相关 API
     */
    @UtilityClass
    public class Qrcode {
        public static final String GET_QRCODE = API_BASE_URL + "/wxa/getwxacode";
        public static final String GET_UNLIMITED_QRCODE = API_BASE_URL + "/wxa/getwxacodeunlimit";
        public static final String CREATE_QRCODE = API_BASE_URL + "/cgi-bin/wxaapp/createwxaqrcode";
    }

    /**
     * URL Scheme
     */
    @UtilityClass
    public class Scheme {
        public static final String GENERATE_NFC_SCHEME = API_BASE_URL + "/wxa/generatenfcscheme";
        public static final String GENERATE_SCHEME = API_BASE_URL + "/wxa/generatescheme";
        public static final String QUERY_SCHEME = API_BASE_URL + "/wxa/queryscheme";
    }

    /**
     * URL Link
     */
    @UtilityClass
    public class UrlLink {
        public static final String GENERATE_URL_LINK = API_BASE_URL + "/wxa/generate_urllink";
        public static final String QUERY_URL_LINK = API_BASE_URL + "/wxa/query_urllink";
        public static final String GENERATE_SHORT_LINK = API_BASE_URL + "/wxa/genwxashortlink";
    }

    /**
     * 消息相关 - 动态消息
     */
    @UtilityClass
    public class Message {
        public static final String CREATE_ACTIVITY_ID = API_BASE_URL + "/cgi-bin/message/wxopen/activityid/create";
        public static final String UPDATE_ACTIVITY_MSG = API_BASE_URL + "/cgi-bin/message/wxopen/updatablemsg/send";
        public static final String GET_CATEGORY = API_BASE_URL + "/wxaapi/newtmpl/getcategory";
        public static final String GET_PUB_TEMPLATE_KEYWORDS = API_BASE_URL + "/wxaapi/newtmpl/getpubtemplatekeywords?tid=%d";
        public static final String GET_PUB_TEMPLATE_TITLE_LIST = API_BASE_URL + "/wxaapi/newtmpl/getpubtemplatetitles";
        public static final String GET_TEMPLATE = API_BASE_URL + "/wxaapi/newtmpl/gettemplate";
        public static final String SUBSCRIBE_MESSAGE_SEND = API_BASE_URL + "/cgi-bin/message/subscribe/send";
        public static final String ADD_TEMPLATE = API_BASE_URL + "/wxaapi/newtmpl/addtemplate";
        public static final String SET_USER_NOTIFY = API_BASE_URL + "/wxa/set_user_notify";
        public static final String GET_USER_NOTIFY = API_BASE_URL + "/wxa/get_user_notify";
        public static final String SET_USER_NOTIFY_EXT = API_BASE_URL + "/wxa/set_user_notifyext";
        public static final String DELETE_TEMPLATE = "/wxaapi/newtmpl/deltemplate";
    }

    /**
     * 内容安全
     */
    @UtilityClass
    public class Security {
        public static final String MSG_SEC_CHECK = API_BASE_URL + "/wxa/msg_sec_check";
        public static final String MEDIA_CHECKA_SYNC = API_BASE_URL + "/wxa/media_check_async";
        public static final String GET_USER_RISK_RANK = API_BASE_URL + "/wxa/getuserriskrank";
    }

    /**
     * 数据分析
     */
    @UtilityClass
    public class Analysis {
        public static final String GET_DAILY_RETAIN = API_BASE_URL + "/datacube/getweanalysisappiddailyretaininfo";
        public static final String GET_WEEKLY_RETAIN = API_BASE_URL + "/datacube/getweanalysisappidweeklyretaininfo";
        public static final String GET_MONTH_RETAIN = API_BASE_URL + "/datacube/getweanalysisappidmonthlyretaininfo";

        public static final String GET_DAILY_VISIT_TREND = API_BASE_URL + "/datacube/getweanalysisappiddailyvisittrend";
        public static final String GET_WEEKLY_VISIT_TREND = API_BASE_URL + "/datacube/getweanalysisappidweeklyvisittrend";
        public static final String GET_MONTHLY_VISIT_TREND = API_BASE_URL + "/datacube/getweanalysisappidmonthlyvisittrend";

        public static final String GET_DAILY_SUMMARY = API_BASE_URL + "/datacube/getweanalysisappiddailysummarytrend";
        public static final String GET_VISIT_PAGE = API_BASE_URL + "/datacube/getweanalysisappidvisitpage";
        public static final String GET_USER_PORTRAIT = API_BASE_URL + "/datacube/getweanalysisappiduserportrait";
        public static final String GET_PERFOR_MANCEDATA = API_BASE_URL + "/wxa/business/performance/boot";
    }

    /**
     * 直播间管理
     */
    @UtilityClass
    public class BroadcastRoom {
        public static final String CREATE_ROOM = API_BASE_URL + "/wxaapi/broadcast/room/create";
        public static final String EDIT_ROOM = API_BASE_URL + "/wxaapi/broadcast/room/editroom";
        public static final String GET_LIVE_INFO = API_BASE_URL + "/wxa/business/getliveinfo";
        public static final String DELETE_ROOM = API_BASE_URL + "/wxaapi/broadcast/room/deleteroom";
        public static final String IMPORT_GOODS = API_BASE_URL + "/wxaapi/broadcast/room/addgoods";
        public static final String GET_PUSH_URL = API_BASE_URL + "/wxaapi/broadcast/room/getpushurl?roomId=%d";
        public static final String GET_SHARE_CODE = API_BASE_URL + "/wxaapi/broadcast/room/getsharedcode";
        public static final String ADD_SUB_ANCHOR = API_BASE_URL + "/wxaapi/broadcast/room/addsubanchor";
        public static final String GET_SUB_ANCHOR = API_BASE_URL + "/wxaapi/broadcast/room/getsubanchor?roomId=%d";
        public static final String MODIFY_SUB_ANCHOR = API_BASE_URL + "/wxaapi/broadcast/room/modifysubanchor";
        public static final String DELETE_SUB_ANCHOR = API_BASE_URL + "/wxaapi/broadcast/room/deletesubanchor";
        public static final String DELETE_GOODS = API_BASE_URL + "/wxaapi/broadcast/goods/deleteInRoom";
        public static final String PUSH_GOODS = API_BASE_URL + "/wxaapi/broadcast/goods/push";
        public static final String MODIFY_GOODS_SALE = API_BASE_URL + "/wxaapi/broadcast/goods/onsale";
        public static final String GOODS_SORT = API_BASE_URL + "/wxaapi/broadcast/goods/sort";
        public static final String GET_ASSISTANT_LIST = API_BASE_URL + "/wxaapi/broadcast/room/getassistantlist?roomId=%d";
        public static final String ADD_ASSISTANT = API_BASE_URL + "/wxaapi/broadcast/room/addassistant";
        public static final String MODIFY_ASSISTANT = API_BASE_URL + "/wxaapi/broadcast/room/modifyassistant";
        public static final String REMOVE_ASSISTANT = API_BASE_URL + "/wxaapi/broadcast/room/removeassistant";
        public static final String UPDATE_COMMENT = API_BASE_URL + "/wxaapi/broadcast/room/updatecomment";
        public static final String UPDATE_FEED_PUBLIC = API_BASE_URL + "/wxaapi/broadcast/room/updatefeedpublic";
        public static final String UPDATE_KF = API_BASE_URL + "/wxaapi/broadcast/room/updatekf";
        public static final String UPDATE_REPLAY = API_BASE_URL + "/wxaapi/broadcast/room/updatereplay";
        public static final String DOWNLOAD_GOODS_VIDEO = API_BASE_URL + "/wxaapi/broadcast/goods/getVideo";
    }

    @UtilityClass
    public class BroadcastGoods {

        public static final String ADD = API_BASE_URL + "/wxaapi/broadcast/goods/add";
        public static final String AUDIT = API_BASE_URL + "/wxaapi/broadcast/goods/audit";
        public static final String GET_GOODS_WARE_HOUSE = API_BASE_URL + "/wxa/business/getgoodswarehouse";
        public static final String RESET_AUDIT = API_BASE_URL + "/wxaapi/broadcast/goods/resetaudit";
        public static final String UPDATE = API_BASE_URL + "/wxaapi/broadcast/goods/update";
        public static final String GET_APPROVED = API_BASE_URL + "/wxaapi/broadcast/goods/getapproved";
        public static final String DELETE = API_BASE_URL + "/wxaapi/broadcast/goods/delete";
    }

    @UtilityClass
    public class BroadcastRole {

        public static final String ADD = API_BASE_URL + "/wxaapi/broadcast/role/addrole";
        public static final String DELETE = API_BASE_URL + "/wxaapi/broadcast/role/deleterole";
        public static final String GET_LIST = API_BASE_URL + "/wxaapi/broadcast/role/getrolelist";
    }

    @UtilityClass
    public class BroadcastMessage {

        public static final String PUSH = API_BASE_URL + "/wxa/business/push_message";
    }

    @UtilityClass
    public class RedPacket {
        public static final String GET_RED_PACKET_COVER_URL = API_BASE_URL + "/redpacketcover/wxapp/cover_url/get_by_token";
    }
}
