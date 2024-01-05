package ink.honp.wx.miniapp.service;

/**
 * @author jeffchen
 * date    2024/01/05 14:52
 */
public interface WxaRedPacketService extends WxaService {

    /**
     * 获取红包封面
     * @param openid    可领取用户的openid,必填
     * @param ctoken    在红包封面平台获取发放ctoken（需要指定可以发放的appid），必填
     * @return 指定用户可以领取的链接（带鉴权的链接）
     */
    String getRedPacketCoverUrl(String openid, String ctoken);
}
