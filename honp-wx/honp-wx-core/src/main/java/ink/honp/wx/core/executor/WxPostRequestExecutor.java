package ink.honp.wx.core.executor;

import ink.honp.core.http.request.PostJsonRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:30
 */
public class WxPostRequestExecutor implements WxRequestExecutor<Response> {

    private final OkHttpClient okHttpClient;

    public WxPostRequestExecutor(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {

        Request request = new PostJsonRequest(url, null, data).build();
        return okHttpClient.newCall(request).execute();
    }
}
