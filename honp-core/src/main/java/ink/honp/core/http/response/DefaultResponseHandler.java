package ink.honp.core.http.response;

import okhttp3.Response;

import java.util.Optional;

/**
 * @author jeffchen
 * date    2023/12/29 14:20
 */
public class DefaultResponseHandler implements ResponseHandler<Response> {

    @Override
    public Optional<Response> handle(Response response) {
        return Optional.of(response);
    }
}
