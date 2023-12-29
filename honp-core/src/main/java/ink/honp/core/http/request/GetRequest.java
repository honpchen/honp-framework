package ink.honp.core.http.request;

import ink.honp.core.http.constant.HttpMethod;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * @author jeffchen
 * date    2023/12/28 18:24
 */
@Getter
public class GetRequest extends AbstractRequest {

    private final String url;
    private final Map<String, String> headers;

    public GetRequest(@NonNull String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public RequestBody getRequestBody() {
        throw new UnsupportedOperationException("Get method unsupported requestBody");
    }
}
