package ink.honp.core.http.request;

import com.fasterxml.jackson.databind.JsonNode;
import ink.honp.core.util.JacksonUtil;
import lombok.Getter;
import okhttp3.FormBody;
import okhttp3.RequestBody;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2023/12/29 11:38
 */
@Getter
public abstract class AbstractFormRequestBodyWrapper extends AbstractRequest {

    private final String url;
    private final Map<String, String> headers;
    private final Object args;

    protected AbstractFormRequestBodyWrapper(String url, Map<String, String> headers, Object args) {
        this.url = url;
        this.headers = headers;
        this.args = args;
    }

    @Override
    public RequestBody getRequestBody() {
        FormBody.Builder builder = new FormBody.Builder();
        if (Objects.isNull(args)) {
            return builder.build();
        }

        JsonNode rootNode = JacksonUtil.readTree(JacksonUtil.toJson(args));
        if (Objects.isNull(rootNode)) {
            return builder.build();
        }

        Iterator<String> fieldNames = rootNode.fieldNames();
        while (fieldNames.hasNext()) {
            String name = fieldNames.next();
            builder.add(name, rootNode.get(name).asText());
        }
        return builder.build();
    }
}
