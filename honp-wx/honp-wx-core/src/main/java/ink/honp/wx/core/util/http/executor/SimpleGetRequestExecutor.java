package ink.honp.wx.core.util.http.executor;

import ink.honp.core.http.OkHttpUtil;
import ink.honp.wx.core.executor.WxRequestExecutor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:30
 */
public class SimpleGetRequestExecutor extends SimpleRequestExecutor {

    private final OkHttpClient httpClient;

    public SimpleGetRequestExecutor(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {
        String urlWithParams = OkHttpUtil.processUrl(url, data);

        Request request = new Request.Builder().url(urlWithParams).get().build();
        return httpClient.newCall(request).execute();
    }
}
