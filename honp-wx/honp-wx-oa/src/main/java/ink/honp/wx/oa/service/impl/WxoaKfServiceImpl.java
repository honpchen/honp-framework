package ink.honp.wx.oa.service.impl;

import ink.honp.wx.oa.client.WxoaClient;
import ink.honp.wx.oa.constant.WxoaUrlConstant;
import ink.honp.wx.oa.entity.request.kf.WxoaKfAccountAddRequest;
import ink.honp.wx.oa.entity.request.kf.WxoaKfAccountUpdateRequest;
import ink.honp.wx.oa.entity.response.kf.WxoaKfListResponse;
import ink.honp.wx.oa.service.WxoaKfService;

import java.io.File;

/**
 * @author jeffchen
 * date    2024/01/09 16:23
 */
public class WxoaKfServiceImpl implements WxoaKfService {

    private final WxoaClient wxoaClient;

    public WxoaKfServiceImpl(WxoaClient wxoaClient) {
        this.wxoaClient = wxoaClient;
    }

    @Override
    public void add(WxoaKfAccountAddRequest accountAddRequest) {

    }

    @Override
    public void update(WxoaKfAccountUpdateRequest accountUpdateRequest) {

    }

    @Override
    public void delete(String kfAccount) {

    }

    @Override
    public void updateKfHeadImg(String kfAccount, File headImg) {

    }

    @Override
    public WxoaKfListResponse list() {

        return wxoaClient.get(WxoaUrlConstant.Kf.LIST, null, WxoaKfListResponse.class);
    }
}
