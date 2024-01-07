package ink.honp.wx.core.executor;

import ink.honp.core.http.OkHttpUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:30
 */
public class WxGetRequestExecutor implements WxRequestExecutor<Response> {

    private final OkHttpClient okHttpClient;

    public WxGetRequestExecutor(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public Response execute(String url, Object data) throws IOException {
        String urlWithParams = OkHttpUtil.processUrl(url, data);

        Request request = new Request.Builder().url(urlWithParams).get().build();
        return okHttpClient.newCall(request).execute();
    }
}
