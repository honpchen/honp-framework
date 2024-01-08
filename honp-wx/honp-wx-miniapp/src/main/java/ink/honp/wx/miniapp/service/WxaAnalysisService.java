package ink.honp.wx.miniapp.service;

import ink.honp.wx.miniapp.entity.response.analysis.*;

/**
 * @author jeffchen
 * date    2024/01/04 17:46
 */
public interface WxaAnalysisService extends WxaService {


    /**
     * 获取用户访问小程序日留存
     * @param beginDate 开始日期。格式为 yyyymmdd, 必填
     * @param endDate 结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd, 必填
     * @return -
     */
    WxaAnalysisRetainResponse getDailyRetain(String beginDate, String endDate);

    /**
     * 获取用户访问小程序周留存
     * @param beginDate 开始日期，为周一日期。格式为 yyyymmdd, 必填
     * @param endDate 结束日期，为周日日期，限定查询一周数据。格式为 yyyymmdd, 必填
     * @return -
     */
    WxaAnalysisRetainResponse getWeeklyRetain(String beginDate, String endDate);

    /**
     * 获取用户访问小程序月留存
     * @param beginDate 开始日期，为自然月第一天。格式为 yyyymmdd, 必填
     * @param endDate 结束日期，为自然月最后一天，限定查询一个月数据。格式为 yyyymmdd, 必填
     * @return -
     */
    WxaAnalysisRetainResponse getMonthlyRetain(String beginDate, String endDate);


    /**
     * 获取用户访问小程序数据日趋势
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate 结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisVisitTrendResponse getDailyVisitTrend(String beginDate, String endDate);

    /**
     * 获取用户访问小程序数据周趋势
     * @param beginDate 开始日期，为周一日期。格式为 yyyymmdd
     * @param endDate 结束日期，为周日日期，限定查询一周数据。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisVisitTrendResponse getWeeklyVisitTrend(String beginDate, String endDate);

    /**
     * 获取用户访问小程序数据月趋势
     * @param beginDate 开始日期，为自然月第一天。格式为 yyyymmdd
     * @param endDate 结束日期，为自然月最后一天，限定查询一个月的数据。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisVisitTrendResponse getMonthlyVisitTrend(String beginDate, String endDate);

    /**
     * 获取用户访问小程序数据概况
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate 结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisDailySummaryResponse getDailySummary(String beginDate, String endDate);

    /**
     * 获取访问页面数据
     * <pre>
     *     该接口用于访问页面。目前只提供按 page_visit_pv 排序的 top200
     * </pre>
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate 结束日期，限定查询1天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisVisitPageResponse getVisitPage(String beginDate, String endDate);

    /**
     * 获取小程序用户画像分布
     * <pre>
     *     该接口用于获取小程序新增或活跃用户的画像分布数据。时间范围支持昨天、最近7天、最近30天。
     *     其中，新增用户数为时间范围内首次访问小程序的去重用户数，活跃用户数为时间范围内访问过小程序的去重用户数
     * </pre>
     * @param beginDate 开始日期。格式为 yyyymmdd
     * @param endDate 结束日期，开始日期与结束日期相差的天数限定为0/6/29，
     *                分别表示查询最近1/7/30天数据，允许设置的最大值为昨日。格式为 yyyymmdd
     * @return -
     */
    WxaAnalysisUserPortraitResponse getUserPortrait(String beginDate, String endDate);
}
