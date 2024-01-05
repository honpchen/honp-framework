package ink.honp.wx.miniapp.service.impl;

import ink.honp.wx.core.entity.response.WxByteResponse;
import ink.honp.wx.core.handler.WxByteResponseHandler;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaQrcodeCreateRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaQrcodeGetRequest;
import ink.honp.wx.miniapp.entity.request.qrcode.WxaQrcodeUnlimitedRequest;
import ink.honp.wx.miniapp.service.WxaQrcodeService;

/**
 * @author jeffchen
 * date    2024/01/05 15:51
 */
public class WxaQrcodeServiceImpl implements WxaQrcodeService {

    private final WxByteResponseHandler byteResponseHandler = new WxByteResponseHandler();

    private final WxaClient wxaClient;

    public WxaQrcodeServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxByteResponse getQrcode(WxaQrcodeGetRequest qrcodeGetRequest) {

        return wxaClient.post(WxaUrlConstant.Qrcode.GET_QRCODE, qrcodeGetRequest, byteResponseHandler);
    }

    @Override
    public WxByteResponse getUnlimitedQrcode(WxaQrcodeUnlimitedRequest qrcodeUnlimitedRequest) {

        return wxaClient.post(WxaUrlConstant.Qrcode.GET_UNLIMITED_QRCODE, qrcodeUnlimitedRequest, byteResponseHandler);
    }

    @Override
    public WxByteResponse createQrcode(WxaQrcodeCreateRequest qrcodeCreateRequest) {

        return wxaClient.post(WxaUrlConstant.Qrcode.CREATE_QRCODE, qrcodeCreateRequest, byteResponseHandler);
    }
}
