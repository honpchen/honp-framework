package ink.honp.core.http;

import com.fasterxml.jackson.databind.JsonNode;
import ink.honp.core.constant.SymbolicConstant;
import ink.honp.core.http.interceptor.OkHttpLogInterceptor;
import ink.honp.core.http.request.*;
import ink.honp.core.http.response.ResponseHandler;
import ink.honp.core.http.response.StringResponseHandler;
import ink.honp.core.util.JacksonUtil;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ThreadUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author jeffchen
 * date    2023/12/28 16:46
 */
@Slf4j
@UtilityClass
public class OkHttpUtil {

    /** http 连接超时时间 **/
    private static final int CONN_TIMEOUT_SEC = 2 * 60;
    private static final int READ_TIMEOUT_SEC = 2 * 60;
    private static final int WRITE_TIMEOUT_SEC = 2 * 60;

    /** 重试间隔最低时间 **/
    private static final int DEFAULT_RETRY_COUNT = 1;
    private static final int DEFAULT_MAX_RETRY_COUNT = 1;
    private static final long RETRY_TIME_MS = 500;


    /** 默认响应处理器， 返回请求体字符串 **/
    private static final ResponseHandler<String> RESPONSE_HANDLER = new StringResponseHandler();
    private static final Map<String, String> NO_HEADERS = null;
    private static final Object NO_ARGS = null;

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(CONN_TIMEOUT_SEC, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SEC, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_SEC, TimeUnit.SECONDS)
            .addInterceptor(new OkHttpLogInterceptor(OkHttpLogInterceptor.Level.BASIC))
            .build();

    public static String get(@NonNull String url) {
        return execute(new GetRequest(processUrl(url, NO_ARGS), NO_HEADERS).build());
    }

    public static String get(@NonNull String url, Map<String, String> headers, Object args) {

        return execute(new GetRequest(processUrl(url, args), headers).build());
    }

    public static String post(@NonNull String url, Object args) {
        return execute(new PostJsonRequest(url, NO_HEADERS, args).build());
    }

    public static String post(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PostJsonRequest(url, headers, args).build());
    }

    public static String postForm(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PostFormRequest(url, headers, args).build());
    }

    public static String put(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PutJsonRequest(url, headers, args).build());
    }

    public static String putForm(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PutFormRequest(url, headers, args).build());
    }

    public static String patch(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PatchJsonRequest(url, headers, args).build());
    }

    public static String patchForm(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new PatchFormRequest(url, headers, args).build());
    }

    public static String delete(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new DeleteJsonRequest(url, headers, args).build());
    }

    public static String deleteForm(@NonNull String url, Map<String, String> headers, Object args) {
        return execute(new DeleteFormRequest(url, headers, args).build());
    }

    public static String processUrl(String url, Object args) {
        if (Objects.isNull(args)) {
            return url;
        }

        JsonNode rootNode = JacksonUtil.readTree(JacksonUtil.toJson(args));
        if (Objects.isNull(rootNode)) {
            return StringUtils.EMPTY;
        }

        Iterator<String> fieldNames = rootNode.fieldNames();

        StringBuilder builder = new StringBuilder();
        while (fieldNames.hasNext()) {
            String name = fieldNames.next();

            builder.append(name).append(SymbolicConstant.EQUAL)
                    .append(URLEncoder.encode(rootNode.get(name).asText(), StandardCharsets.UTF_8))
                    .append(SymbolicConstant.AMPLE);
        }
        String parameters = builder.deleteCharAt(builder.length() - 1).toString();

        return url.contains(SymbolicConstant.QUESTION) ? url + SymbolicConstant.AMPLE + parameters
                : url + SymbolicConstant.QUESTION + parameters;
    }

    public static String execute(Request request) {
        return execute(HTTP_CLIENT, request, RESPONSE_HANDLER, DEFAULT_RETRY_COUNT, DEFAULT_MAX_RETRY_COUNT);
    }

    public static <T> T execute(OkHttpClient httpClient, Request request, ResponseHandler<T> responseHandler) {
        return execute(httpClient, request, responseHandler, DEFAULT_RETRY_COUNT, DEFAULT_MAX_RETRY_COUNT);
    }

    /**
     * HTTP 请求 , 若失败重试，重试等待 500ms << retryCount
     * @param httpClient        OkHttp Client
     * @param request           Request
     * @param responseHandler   响应处理器
     * @param retryCount        重试次数，每次重试 >> 1
     * @param maxRetryCount     max retry count
     * @return 失败或异常返回空
     * @param <T> 返回类型
     */
    public static <T> T execute(OkHttpClient httpClient,
                                Request request,
                                ResponseHandler<T> responseHandler,
                                int retryCount,
                                int maxRetryCount) {
        try {
            Response response = httpClient.newCall(request).execute();
            return responseHandler.handle(response).orElse(null);
        } catch (SocketTimeoutException ex) {
            if (retryCount <= maxRetryCount) {
                log.error("请求重试 {} 次均失败, 请检查你的网络状态！", retryCount);
                try {
                    ThreadUtils.sleep(Duration.ofMillis(RETRY_TIME_MS << retryCount));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // 执行重试
                return execute(httpClient, request, responseHandler, ++retryCount, maxRetryCount);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void addInterceptor(List<Interceptor> interceptors) {
        HTTP_CLIENT.interceptors().addAll(interceptors);
    }

    public static void setLevel(@NonNull OkHttpLogInterceptor.Level level) {
        List<Interceptor> interceptors = HTTP_CLIENT.interceptors();
        interceptors.stream()
                .filter(OkHttpLogInterceptor.class::isInstance)
                .findFirst()
                .ifPresent(interceptor -> {
                    OkHttpLogInterceptor logInterceptor = (OkHttpLogInterceptor) interceptor;
                    logInterceptor.setLevel(level);
                });
    }
}
