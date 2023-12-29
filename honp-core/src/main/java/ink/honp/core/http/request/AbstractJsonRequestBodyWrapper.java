package ink.honp.core.http.request;

import ink.honp.core.util.JacksonUtil;
import ink.honp.core.http.constant.ContentType;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2023/12/29 11:38
 */
@Getter
public abstract class AbstractJsonRequestBodyWrapper extends AbstractRequest {

    private final String url;
    private final Map<String, String> headers;
    private final Object args;

    protected AbstractJsonRequestBodyWrapper(@NonNull String url, Map<String, String> headers, Object args) {
        this.url = url;
        this.headers = headers;
        this.args = args;
    }

    @Override
    public RequestBody getRequestBody() {
        String bodyContent = StringUtils.EMPTY;
        if (Objects.nonNull(args)) {
            bodyContent = JacksonUtil.toJson(args);
        }
        return RequestBody.create(bodyContent, MediaType.parse(ContentType.APPLICATION_JSON));
    }
}
