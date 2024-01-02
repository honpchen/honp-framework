package ink.honp.wx.core.executor;

import ink.honp.core.http.OkHttpUtil;
import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.handler.WxResponseHandler;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:30
 */
public class WxSimpleGetRequestExecutor implements WxRequestExecutor<Object, String> {

    private final OkHttpClient okHttpClient;

    public WxSimpleGetRequestExecutor(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public String execute(String url, Object data, WxResponseHandler<String> responseHandler)
            throws WxException, IOException {
        String urlWithParams = OkHttpUtil.processUrl(url, data);

        Request request = new Request.Builder().url(urlWithParams).get().build();
        Response response = okHttpClient.newCall(request).execute();

        return responseHandler.handle(response);
    }
}
