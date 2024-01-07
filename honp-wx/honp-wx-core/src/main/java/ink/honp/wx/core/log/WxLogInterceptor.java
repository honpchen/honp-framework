package ink.honp.wx.core.log;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.core.http.interceptor.OkHttpAbstractLogInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

/**
 * OK Http 请求日志
 * @author jeffchen
 * date    2023/12/28 16:53
 */
@Slf4j
public class WxLogInterceptor extends OkHttpAbstractLogInterceptor {

    private static final String DEFAULT_TAG = "WX";

    public WxLogInterceptor(HttpLogLevel level) {
        super(DEFAULT_TAG, level);
    }

    public WxLogInterceptor(String tag, HttpLogLevel level) {
        super(tag, level);
    }


    @Override
    public String formatLogMessage(Request request, Response response) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("Request:\n")
                    .append("   Method: ").append(request.method()).append("\n")
                    .append("   URL: ").append(request.url()).append("\n");

            if (HttpLogLevel.BODY.equals(getLevel())) {
                builder.append("   Request body: ").append(getRequestBody(request)).append("\n")
                        .append("Response:\n")
                        .append("   Status code: ").append(response.code()).append("\n");
            }
            return builder.toString();

        }catch (Exception ex) {
            log.error("[{}] format log message error.", getTag(), ex);
            return StringUtils.EMPTY;
        }
    }
}
