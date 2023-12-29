package ink.honp.core.http.response;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

/**
 * @author jeffchen
 * date    2023/12/29 11:12
 */
@Slf4j
public class StringResponseHandler implements ResponseHandler<String> {

    @Override
    public Optional<String> handle(Response response) throws IOException {
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            String content = body.string();
            response.close();
            return Optional.of(content);
        }
        return Optional.empty();
    }
}
