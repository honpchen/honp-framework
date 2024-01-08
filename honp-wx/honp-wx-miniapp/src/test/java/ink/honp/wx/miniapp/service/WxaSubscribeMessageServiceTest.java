package ink.honp.wx.miniapp.service;

import ink.honp.core.util.CollectionUtil;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.request.msg.WxaMessageSendRequest;
import ink.honp.wx.miniapp.entity.request.msg.WxaPubTemplateTitlePageRequest;
import ink.honp.wx.miniapp.entity.response.msg.WxaCategoryResponse;
import ink.honp.wx.miniapp.entity.response.msg.WxaMessageTemplateResponse;
import ink.honp.wx.miniapp.entity.response.msg.WxaPubTemplateKeyWordResponse;
import ink.honp.wx.miniapp.entity.response.msg.WxaPubTemplateTitleListResponse;
import ink.honp.wx.miniapp.service.impl.WxaSubscribeMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/08 10:19
 */
@Slf4j
class WxaSubscribeMessageServiceTest extends WxaServiceTest{
    
    @Test
    void testGetCategory() {
        WxaSubscribeMessageService wxaSubscribeMessageService = new WxaSubscribeMessageServiceImpl(getWxaClient());

        WxaCategoryResponse category = wxaSubscribeMessageService.getCategory();
        Assertions.assertNotNull(category);

        // {"errcode":0,"errmsg":"ok","data":[{"id":221,"name":"餐饮信息服务"},{"id":307,"name":"服饰内衣"},
        // {"id":315,"name":"珠宝玉石"},{"id":32,"name":"在线教育"},{"id":640,"name":"旅游资讯"}],"success":true}
        log.info("Category:{}", JacksonUtil.toJson(category));

    }

    @Test
    void testGetPubTemplateKeywords() {
        WxaSubscribeMessageService wxaSubscribeMessageService = new WxaSubscribeMessageServiceImpl(getWxaClient());

        WxaPubTemplateKeyWordResponse response = wxaSubscribeMessageService.getPubTemplateKeyWordsById(662L);

        Assertions.assertNotNull(response);

        // {"errcode":0,"errmsg":"ok","data":[]
        log.info("WxaPubTemplateKeywords:{}", JacksonUtil.toJson(response));
    }

    @Test
    void testGetPubTemplateTitleList() {
        WxaSubscribeMessageService wxaSubscribeMessageService = new WxaSubscribeMessageServiceImpl(getWxaClient());

        WxaPubTemplateTitlePageRequest  pageRequest = new WxaPubTemplateTitlePageRequest()
                .setIds("221");
        pageRequest.setStart(0);
        pageRequest.setLimit(1);
        WxaPubTemplateTitleListResponse response = wxaSubscribeMessageService.getPubTemplateTitleList(pageRequest);
        Assertions.assertNotNull(response);

        log.info("WxaPubTemplateTitleList:{}", JacksonUtil.toJson(response));
    }


    @Test
    void testGetTemplateList() {
        WxaSubscribeMessageService wxaSubscribeMessageService = new WxaSubscribeMessageServiceImpl(getWxaClient());

        WxaMessageTemplateResponse messageTemplateList = wxaSubscribeMessageService.getMessageTemplateList();
        Assertions.assertNotNull(messageTemplateList);

        log.info("WxaMessageTemplateList:{}", JacksonUtil.toJson(messageTemplateList));
    }

    @Test
    void testSendMessage() {
        WxaSubscribeMessageService wxaSubscribeMessageService = new WxaSubscribeMessageServiceImpl(getWxaClient());

        WxaMessageSendRequest.WxaMessageData thing1 = new WxaMessageSendRequest.WxaMessageData("thing1", "绚烂");
        WxaMessageSendRequest.WxaMessageData date3 = new WxaMessageSendRequest.WxaMessageData("thing1", "绚烂");
        WxaMessageSendRequest.WxaMessageData thing4 = new WxaMessageSendRequest.WxaMessageData("thing1", "绚烂");


        WxaMessageSendRequest sendRequest = new WxaMessageSendRequest()
                .setTemplateId("FN-pRvXNtY-82-YFMgqzrG80x7pPos3CNJ0i4Ite_mc")
                .setTouser("oxMZd5QIXaS2nFM-vVRYsVXIFzkY")
                .setData(Arrays.asList(thing1, date3, thing4));


        Assertions.assertDoesNotThrow(() -> wxaSubscribeMessageService.sendMessage(sendRequest));
    }
}
