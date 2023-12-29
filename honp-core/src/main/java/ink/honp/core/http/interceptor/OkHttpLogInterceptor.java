package ink.honp.core.http.interceptor;

import ink.honp.core.http.constant.ContentType;
import ink.honp.core.http.constant.HeaderName;
import ink.honp.core.http.constant.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * OK Http 请求日志
 * @author jeffchen
 * date    2023/12/28 16:53
 */
@Slf4j
public class OkHttpLogInterceptor implements Interceptor {

    private static final String TAG = "okhttp";

    private final Level level;

    public OkHttpLogInterceptor() {
        this(Level.BASIC);
    }

    public OkHttpLogInterceptor(Level level) {
        this.level = level;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        if (Level.NONE.equals(level)) {
            return response;
        }

        String logMessage = formatLogMessage(request, response);
        log.info("{} {}", TAG, logMessage);

        return response;
    }


    private String formatLogMessage(Request request, Response response) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("Request:\n")
                    .append("   Method: ").append(request.method()).append("\n")
                    .append("   URL: ").append(request.url()).append("\n");
            if (Level.HEADERS.equals(level)) {
                builder.append("   Headers: ").append(request.headers()).append("\n");
                return builder.toString();
            }

            if (Level.BODY.equals(level)) {
                builder.append("   Headers: ").append(request.headers())
                        .append("   Request body: ").append(getRequestBody(request)).append("\n")
                        .append("Response:\n")
                        .append("   Status code: ").append(response.code()).append("\n");
            }
            return builder.toString();

        }catch (Exception ex) {
            log.error("{} format log message error.", TAG, ex);
            return StringUtils.EMPTY;
        }
    }


    private String getRequestBody(Request request) {
        if (HttpMethod.GET.getCode().equalsIgnoreCase(request.method())) {
            return StringUtils.EMPTY;
        }

        if (ContentType.MULTIPART_FORM_DATA.equals(request.header(HeaderName.CONTENT_TYPE))) {
            return "[upload file]";
        }

        RequestBody body = request.body();
        if (Objects.nonNull(body)) {
            return body.toString();
        }
        return StringUtils.EMPTY;
    }

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }
}
