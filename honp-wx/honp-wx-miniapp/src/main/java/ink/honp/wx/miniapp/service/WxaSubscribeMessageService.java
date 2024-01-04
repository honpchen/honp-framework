package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.request.msg.*;
import ink.honp.wx.miniapp.entity.response.msg.*;

/**
 * @author jeffchen
 * date    2024/01/04 15:05
 */
public interface WxaSubscribeMessageService extends WxaService {

    /**
     * 删除模板
     * <pre>
     *     该接口用于删除账号下的个人模板
     * </pre>
     * @param priTmplId 要删除的模板id
     */
    void deleteMessageTemplate(String priTmplId);

    /**
     * 获取类目
     * <pre>
     *     该接口用于获取小程序账号的类目
     * </pre>
     * @return 类目列表
     */
    WxaCategoryResponse getCategory();

    /**
     * 获取关键词列表
     * @param tid 模板标题 id
     * @return 关键词列表
     */
    WxaPubTemplateKeyWordResponse getPubTemplateKeyWordsById(String tid);

    /**
     * 获取所属类目下的公共模板
     * @param getRequest -
     * @return 公共模板标题列表
     */
    WxaPubTemplateTitleListResponse getPubTemplateTitleList(WxaPubTemplateTitleListGetRequest getRequest);

    /**
     * 获取个人模板列表
     * @return 模板标题下的帐号模板列表
     */
    WxaMessageTemplateResponse getMessageTemplateList();

    /**
     * 发送订阅消息
     * @param sendRequest -
     */
    void sendMessage(WxaMessageSendRequest sendRequest);

    /**
     * 添加模板
     * @param addRequest -
     * @return 模板id
     */
    WxaMessageTemplateIdResponse addMessageTemplate(WxaMessageTemplateAddRequest addRequest);

    /**
     * 激活与更新服务卡片
     * @param notifySetRequest -
     */
    void setUserNotify(WxaUserNotifySetRequest notifySetRequest);

    /**
     * 查询服务卡片状态
     * @param notifyGetRequest -
     * @return 服务卡片状态
     */
    WxaUserNotifyResponse getUserNotify(WxaUserNotifyRequest notifyGetRequest);

    /**
     * 更新服务卡片扩展信息
     * @param notifyExtSetRequest -
     */
    void setUserNotifyExt(WxaUserNotifyExtSetRequest notifyExtSetRequest);

}
