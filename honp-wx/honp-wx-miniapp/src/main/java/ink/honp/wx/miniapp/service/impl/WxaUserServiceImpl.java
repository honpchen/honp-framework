package ink.honp.wx.miniapp.service.impl;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.user.WxaPhoneNumberGetRequest;
import ink.honp.wx.miniapp.entity.request.user.WxaUserGetPaidUnionidRequest;
import ink.honp.wx.miniapp.entity.response.user.WxaUserOpenIdResponse;
import ink.honp.wx.miniapp.entity.response.user.WxaUserPhoneInfoResponse;
import ink.honp.wx.miniapp.entity.response.user.WxaUserUnionIdResponse;
import ink.honp.wx.miniapp.service.WxaUserService;
import lombok.NonNull;

import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/05 15:33
 */
public class WxaUserServiceImpl implements WxaUserService {

    private final WxaClient wxaClient;

    public WxaUserServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaUserOpenIdResponse getPluginOpenPId(@NonNull String code) {
        Map<String, String> requestData = CollectionUtil.newHashMap();
        requestData.put("code", code);

        return wxaClient.post(WxaUrlConstant.User.GET_PLUGIN_OPEN_PID, requestData, WxaUserOpenIdResponse.class);
    }

    @Override
    public WxaUserUnionIdResponse getPaidUnionid(WxaUserGetPaidUnionidRequest paidUnionidRequest) {

        return wxaClient.post(WxaUrlConstant.User.GET_PAID_UNIONID, paidUnionidRequest, WxaUserUnionIdResponse.class);
    }

    @Override
    public WxaUserPhoneInfoResponse getPhoneNumber(WxaPhoneNumberGetRequest phoneNumberGetRequest) {

        return wxaClient.post(WxaUrlConstant.User.GET_PHONE_NUMBER, phoneNumberGetRequest, WxaUserPhoneInfoResponse.class);
    }
}
