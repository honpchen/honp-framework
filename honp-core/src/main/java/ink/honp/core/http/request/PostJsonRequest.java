package ink.honp.core.http.request;

import ink.honp.core.http.constant.HttpMethod;
import lombok.NonNull;

import java.util.Map;

/**
 * @author jeffchen
 * date    2023/12/29 13:34
 */
public class PostJsonRequest extends AbstractJsonRequestBodyWrapper {

    public PostJsonRequest(@NonNull String url, Map<String, String> headers, Object args) {
        super(url, headers, args);
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
