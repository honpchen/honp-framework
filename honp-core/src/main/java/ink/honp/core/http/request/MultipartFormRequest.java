package ink.honp.core.http.request;

import ink.honp.core.http.constant.HeaderName;
import ink.honp.core.http.constant.ContentType;
import ink.honp.core.http.constant.HttpMethod;
import ink.honp.core.util.CollectionUtil;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.Map;
import java.util.Objects;

/**
 * @author jeffchen
 * date    2023/12/29 14:23
 */
@Getter
public class MultipartFormRequest extends AbstractRequest {

    private final String url;
    private final Map<String, String> headers;
    private final Map<String, File> args;

    public MultipartFormRequest(@NonNull String url, Map<String, String> headers, @NonNull Map<String, File> args) {
        if (Objects.isNull(headers)) {
            headers = CollectionUtil.newHashMap();
            headers.put(HeaderName.CONTENT_TYPE, ContentType.MULTIPART_FORM_DATA);
        }
        this.url = url;
        this.headers = headers;
        this.args = args;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public RequestBody getRequestBody() {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        args.forEach((name, file) -> builder.addFormDataPart(name, file.getName(),
                RequestBody.create(file, MediaType.parse(ContentType.MULTIPART_FORM_DATA))));
        return builder.build();
    }
}
