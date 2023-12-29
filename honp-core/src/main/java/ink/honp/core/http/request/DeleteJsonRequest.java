package ink.honp.core.http.request;

import ink.honp.core.http.constant.HttpMethod;
import lombok.NonNull;

import java.util.Map;

/**
 * @author jeffchen
 * date    2023/12/29 14:14
 */
public class DeleteJsonRequest extends AbstractJsonRequestBodyWrapper {

    public DeleteJsonRequest(@NonNull String url, Map<String, String> headers, Object args) {
        super(url, headers, args);
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.DELETE;
    }
}
