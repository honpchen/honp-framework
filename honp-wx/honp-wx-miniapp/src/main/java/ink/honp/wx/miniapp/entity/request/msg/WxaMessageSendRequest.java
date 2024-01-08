package ink.honp.wx.miniapp.entity.request.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import ink.honp.core.util.CollectionUtil;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.constant.WxConstant;
import ink.honp.wx.core.constant.WxLang;
import ink.honp.wx.core.entity.request.WxRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/04 16:10
 */
@Data
@Accessors(chain = true)
public class WxaMessageSendRequest implements WxRequest {

    /**
     * 模板id, 必填
     */
    @JsonProperty("template_id")
    private String templateId;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;

    /**
     * 接收者（用户）的 openid， 必填
     */
    private String touser;

    /**
     * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }的object
     * 必填
     */
    private String data;

    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    @JsonProperty("miniprogram_state")
    private String miniprogramState = "formal";

    /**
     * 进入小程序查看”的语言类型，
     * 支持zh_CN(简体中文)、en_US(英文)、zh_HK(繁体中文)、zh_TW(繁体中文)，默认为zh_CN
     */
    private String lang = WxLang.ZH_CN;


    public WxaMessageSendRequest setData(List<WxaMessageData> dataList) {
        Map<String, Map<String, String>> dataMap = CollectionUtil.newHashMap(4);
        dataList.forEach(msgData -> {
            Map<String, String> valueMap = CollectionUtil.newHashMap();
            valueMap.put(WxConstant.VALUE, msgData.getValue());

            dataMap.put(msgData.getKey(), valueMap);
        });

        this.data = JacksonUtil.toJson(dataMap);
        return this;
    }


    @Data
    public static class WxaMessageData {

        private String key;

        private String value;

        public WxaMessageData(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
