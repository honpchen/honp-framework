package ink.honp.core.http.request;

import ink.honp.core.http.constant.HttpMethod;
import lombok.Getter;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2023/12/28 17:50
 */
@Getter
public abstract class AbstractRequest {

    /**
     * 构建请求
     * @return 不能返回空
     */
    public Request build() {
        Request.Builder requestBuilder = new Request.Builder()
                .url(getUrl())
                .headers(processHeaders(getHeaders()));
        switch (getMethod()) {
            case POST:
                requestBuilder.post(getRequestBody());
                break;
            case PUT:
                requestBuilder.put(getRequestBody());
                break;
            case PATCH:
                requestBuilder.patch(getRequestBody());
                break;
            case DELETE:
                requestBuilder.delete(getRequestBody());
                break;
            default:
                requestBuilder.get();
        }
        return requestBuilder.build();
    }

    public abstract HttpMethod getMethod();

    public abstract String getUrl();

    public abstract Map<String, String> getHeaders();

    public abstract RequestBody getRequestBody();


    private Headers processHeaders(Map<String, String> headers) {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (Objects.nonNull(headers)) {
            headers.forEach(headerBuilder::add);
        }
        return headerBuilder.build();
    }
}
