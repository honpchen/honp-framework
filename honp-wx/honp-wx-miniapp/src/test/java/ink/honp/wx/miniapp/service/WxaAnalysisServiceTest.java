package ink.honp.wx.miniapp.service;

import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.miniapp.entity.response.analysis.WxaAnalysisRetainResponse;
import ink.honp.wx.miniapp.entity.response.analysis.WxaAnalysisUserPortraitResponse;
import ink.honp.wx.miniapp.service.impl.WxaAnalysisServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author jeffchen
 * date    2024/01/08 14:22
 */
@Slf4j
class WxaAnalysisServiceTest extends WxaServiceTest {

    @Test
    void testGetDailyRetain() {
        String beginDate = "20231212";
        String endDate = "20231212";

        WxaAnalysisService wxaAnalysisService = new WxaAnalysisServiceImpl(getWxaClient());
        WxaAnalysisRetainResponse dailyRetain = wxaAnalysisService.getDailyRetain(beginDate, endDate);

        Assertions.assertNotNull(dailyRetain);
        log.info("Wxa daily retain:{}", JacksonUtil.toJson(dailyRetain));
    }


    @Test
    void testGetWeekRetain() {
        String beginDate = "20230501";
        String endDate = "20230507";

        WxaAnalysisService wxaAnalysisService = new WxaAnalysisServiceImpl(getWxaClient());
        WxaAnalysisRetainResponse weeklyRetain = wxaAnalysisService.getWeeklyRetain(beginDate, endDate);

        Assertions.assertNotNull(weeklyRetain);
        log.info("Wxa week retain:{}", JacksonUtil.toJson(weeklyRetain));
    }

    @Test
    void testGetMonthRetain() {
        String beginDate = "20240101";
        String endDate = "20240101";

        WxaAnalysisService wxaAnalysisService = new WxaAnalysisServiceImpl(getWxaClient());
        WxaAnalysisRetainResponse monthlyRetain = wxaAnalysisService.getMonthlyRetain(beginDate, endDate);

        Assertions.assertNotNull(monthlyRetain);
        log.info("Wxa month retain:{}", JacksonUtil.toJson(monthlyRetain));
    }

    @Test
    void testGetUserPortrait() {
        String beginDate = "20230301";
        String endDate = "20230331";

        WxaAnalysisService wxaAnalysisService = new WxaAnalysisServiceImpl(getWxaClient());
        WxaAnalysisUserPortraitResponse userPortrait = wxaAnalysisService.getUserPortrait(beginDate, endDate);

        Assertions.assertNotNull(userPortrait);
        log.info("Wxa user portrait:{}", JacksonUtil.toJson(userPortrait));
    }
}
