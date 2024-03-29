package ink.honp.core.http.interceptor;

import ink.honp.core.http.constant.ContentType;
import ink.honp.core.http.constant.HeaderName;
import ink.honp.core.http.constant.HttpMethod;
import ink.honp.core.http.enums.HttpLogLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * OK Http 请求日志
 * @author jeffchen
 * date    2023/12/28 16:53
 */
@Getter
@Slf4j
public abstract class OkHttpAbstractLogInterceptor implements Interceptor {

    private final String tag;
    private HttpLogLevel level;

    protected OkHttpAbstractLogInterceptor(String tag, HttpLogLevel level) {
        this.tag = tag;
        this.level = level;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        if (HttpLogLevel.NONE.equals(level)) {
            return response;
        }

        String logMessage = formatLogMessage(request, response);
        log.info("[{}] {}", tag, logMessage);

        return response;
    }

    public void setLevel(HttpLogLevel level) {
        this.level = level;
    }

    public abstract String formatLogMessage(Request request, Response response);


    public String getRequestBody(Request request) {
        if (HttpMethod.GET.getCode().equalsIgnoreCase(request.method())) {
            return StringUtils.EMPTY;
        }

        if (ContentType.MULTIPART_FORM_DATA.equals(request.header(HeaderName.CONTENT_TYPE))) {
            return "[upload file]";
        }

        RequestBody requestBody = request.body();
        if (Objects.nonNull(requestBody)) {
            try {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                return buffer.readString(StandardCharsets.UTF_8);
            } catch (IOException e) {
                log.warn("{} get request body error", tag, e);
            }
        }
        return StringUtils.EMPTY;
    }
}
