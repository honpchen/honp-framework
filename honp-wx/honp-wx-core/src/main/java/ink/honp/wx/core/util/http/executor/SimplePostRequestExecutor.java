package ink.honp.wx.core.util.http.executor;

import ink.honp.core.http.request.PostJsonRequest;
import ink.honp.wx.core.executor.WxRequestExecutor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:30
 */
public class SimplePostRequestExecutor extends SimpleRequestExecutor {

    private final OkHttpClient httpClient;

    public SimplePostRequestExecutor(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {

        Request request = new PostJsonRequest(url, null, data).build();
        return httpClient.newCall(request).execute();
    }
}
