package ink.honp.core.http.request;

import ink.honp.core.http.constant.HttpMethod;
import lombok.NonNull;

import java.util.Map;

/**
 * @author jeffchen
 * date    2023/12/29 14:14
 */
public class DeleteFormRequest extends AbstractFormRequestBodyWrapper {

    public DeleteFormRequest(@NonNull String url, Map<String, String> headers, Object args) {
        super(url, headers, args);
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.DELETE;
    }
}
