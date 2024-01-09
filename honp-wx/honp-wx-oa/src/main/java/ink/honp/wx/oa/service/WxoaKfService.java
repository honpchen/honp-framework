package ink.honp.wx.oa.service;

import ink.honp.wx.oa.entity.request.kf.WxoaKfAccountAddRequest;
import ink.honp.wx.oa.entity.request.kf.WxoaKfAccountUpdateRequest;
import ink.honp.wx.oa.entity.response.kf.WxoaKfListResponse;

import java.io.File;

/**
 * @author jeffchen
 * date    2024/01/09 16:19
 */
public interface WxoaKfService extends WxoaService {

    /**
     * 添加客服帐号
     * <pre>
     *     开发者可以通过本接口为公众号添加客服账号，每个公众号最多添加100个客服账号
     * </pre>
     * @param accountAddRequest 客服帐号信息
     */
    void add(WxoaKfAccountAddRequest accountAddRequest);

    /**
     * 添加客服帐号
     * <pre>
     *     开发者可以通过本接口为公众号修改客服账号
     * </pre>
     * @param accountUpdateRequest 客服帐号信息
     */
    void update(WxoaKfAccountUpdateRequest accountUpdateRequest);

    /**
     * 删除客服帐号
     * <pre>
     *     开发者可以通过该接口为公众号删除客服账号
     * </pre>
     * @param kfAccount 客服帐号
     */
    void delete(String kfAccount);

    /**
     * 修改客服头像
     * <pre>
     *     开发者可调用本接口来上传图片作为客服人员的头像，头像图片文件必须是jpg格式，推荐使用640*640大小的图片以达到最佳效果
     * </pre>
     * @param kfAccount 客服帐号
     * @param headImg 头像图片,jpg格式
     */
    void updateKfHeadImg(String kfAccount, File headImg);

    /**
     * 获取所有客服账号
     * <pre>
     *     开发者通过本接口，获取公众号中所设置的客服基本信息，包括客服工号、客服昵称、客服登录账号
     * </pre>
     * @return 客服列表
     */
    WxoaKfListResponse list();
}
