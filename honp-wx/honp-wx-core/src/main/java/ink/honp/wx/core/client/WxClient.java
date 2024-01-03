package ink.honp.wx.core.client;

import okhttp3.OkHttpClient;

import java.util.List;

/**
 * @author jeff chen
 * @since 2023-12-31 22:56
 */
public interface WxClient {

    String get(String url, Object queryParams);

    <T> T get(String url, Object queryParams, Class<T> repClz);

    <T> List<T> getList(String url, Object queryParams, Class<T> repClz);

    String post(String url, Object data);

    <T> T post(String url, Object data, Class<T> repClz);

    OkHttpClient getOkHttpClient();

    void setOkHttpClient(OkHttpClient httpClient);
}
