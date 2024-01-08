package ink.honp.wx.miniapp.service;

import ink.honp.wx.core.entity.response.WxTraceResponse;
import ink.honp.wx.miniapp.entity.request.sec.WxaMediaCheckAsyncRequest;
import ink.honp.wx.miniapp.entity.request.sec.WxaMsgSecCheckRequest;
import ink.honp.wx.miniapp.entity.request.sec.WxaUserRiskRankGetRequest;
import ink.honp.wx.miniapp.entity.response.sec.WxaMsgSecCheckResponse;
import ink.honp.wx.miniapp.entity.response.sec.WxaUserRiskRankResponse;

/**
 * @author jeffchen
 * date    2024/01/04 16:57
 */
public interface WxaSecurityService extends WxaService {

    /**
     * 文本内容安全识别
     * <pre>
     *     该接口用于检查一段文本是否含有违法违规内容
     * </pre>
     * @param msgSecCheckRequest -
     * @return -
     */
    WxaMsgSecCheckResponse msgSecCheck(WxaMsgSecCheckRequest msgSecCheckRequest);

    /**
     * 音视频内容安全识别
     * <pre>
     *     本接口用于异步校验图片/音频是否含有违法违规内容
     *     结果会通过消息推送通知
     * </pre>
     * @param mediaCheckAsyncRequest -
     * @return 唯一请求标识  trace_id，标记单次请求
     */
    String mediaCheckAsync(WxaMediaCheckAsyncRequest mediaCheckAsyncRequest);

    /**
     * 获取用户安全等级
     * @param userRiskRankGetRequest -
     * @return -
     */
    WxaUserRiskRankResponse getUserRiskRank(WxaUserRiskRankGetRequest userRiskRankGetRequest);
}
