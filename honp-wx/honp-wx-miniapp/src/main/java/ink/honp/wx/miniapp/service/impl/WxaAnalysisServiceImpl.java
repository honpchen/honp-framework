package ink.honp.wx.miniapp.service.impl;

import ink.honp.core.util.CollectionUtil;
import ink.honp.wx.miniapp.client.WxaClient;
import ink.honp.wx.miniapp.constant.WxaUrlConstant;
import ink.honp.wx.miniapp.entity.response.analysis.*;
import ink.honp.wx.miniapp.service.WxaAnalysisService;

import java.util.Map;

/**
 * @author jeffchen
 * date    2024/01/08 13:59
 */
public class WxaAnalysisServiceImpl implements WxaAnalysisService {

    private static final String BEGIN_DATE = "begin_date";
    private static final String END_DATE = "end_date";

    private final WxaClient wxaClient;

    public WxaAnalysisServiceImpl(WxaClient wxaClient) {
        this.wxaClient = wxaClient;
    }

    @Override
    public WxaAnalysisRetainResponse getDailyRetain(String beginDate, String endDate) {
        return wxaClient.post(WxaUrlConstant.Analysis.GET_DAILY_RETAIN,
                dateRangeQuery(beginDate, endDate), WxaAnalysisRetainResponse.class);
    }

    @Override
    public WxaAnalysisRetainResponse getWeeklyRetain(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_WEEKLY_RETAIN,
                dateRangeQuery(beginDate, endDate), WxaAnalysisRetainResponse.class);
    }

    @Override
    public WxaAnalysisRetainResponse getMonthlyRetain(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_MONTH_RETAIN,
                dateRangeQuery(beginDate, endDate), WxaAnalysisRetainResponse.class);
    }

    @Override
    public WxaAnalysisVisitTrendResponse getDailyVisitTrend(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_DAILY_VISIT_TREND,
                dateRangeQuery(beginDate, endDate), WxaAnalysisVisitTrendResponse.class);
    }

    @Override
    public WxaAnalysisVisitTrendResponse getWeeklyVisitTrend(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_WEEKLY_VISIT_TREND,
                dateRangeQuery(beginDate, endDate), WxaAnalysisVisitTrendResponse.class);
    }

    @Override
    public WxaAnalysisVisitTrendResponse getMonthlyVisitTrend(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_MONTHLY_VISIT_TREND,
                dateRangeQuery(beginDate, endDate), WxaAnalysisVisitTrendResponse.class);
    }

    @Override
    public WxaAnalysisDailySummaryResponse getDailySummary(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_DAILY_SUMMARY,
                dateRangeQuery(beginDate, endDate), WxaAnalysisDailySummaryResponse.class);
    }

    @Override
    public WxaAnalysisVisitPageResponse getVisitPage(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_VISIT_PAGE,
                dateRangeQuery(beginDate, endDate), WxaAnalysisVisitPageResponse.class);
    }

    @Override
    public WxaAnalysisUserPortraitResponse getUserPortrait(String beginDate, String endDate) {

        return wxaClient.post(WxaUrlConstant.Analysis.GET_USER_PORTRAIT,
                dateRangeQuery(beginDate, endDate), WxaAnalysisUserPortraitResponse.class);
    }

    private Map<String, String> dateRangeQuery(String beginDate, String endDate) {
        Map<String, String> params = CollectionUtil.newHashMap();
        params.put(BEGIN_DATE, beginDate);
        params.put(END_DATE, endDate);

        return params;
    }
}
