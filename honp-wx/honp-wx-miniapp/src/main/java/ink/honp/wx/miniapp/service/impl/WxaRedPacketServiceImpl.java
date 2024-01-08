package ink.honp.wx.miniapp.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import ink.honp.core.util.CollectionUtil;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.service.WxaRedPacketService;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2024/01/08 17:05
 */
public class WxaRedPacketServiceImpl implements WxaRedPacketService {

    private final WxaClient wxaClient;

    public WxaRedPacketServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public String getRedPacketCoverUrl(String openid, String ctoken) {
        Map<String, String> queryParams = CollectionUtil.newHashMap();
        queryParams.put("openid", openid);
        queryParams.put("ctoken", ctoken);

        String response = wxaClient.post(WxaUrlConstant.RedPacket.GET_RED_PACKET_COVER_URL, queryParams);
        if (StringUtils.isBlank(response)) {
            return StringUtils.EMPTY;
        }

        JsonNode responseNode = JacksonUtil.readTree(response);
        if (Objects.isNull(responseNode)) {
            return StringUtils.EMPTY;
        }

        JsonNode dataNode = responseNode.get("data");
        if (Objects.isNull(dataNode)) {
            return StringUtils.EMPTY;
        }

        return dataNode.get("url").asText();
    }
}
