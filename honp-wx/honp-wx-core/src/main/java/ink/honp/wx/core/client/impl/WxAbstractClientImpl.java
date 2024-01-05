package ink.honp.wx.core.client.impl;

import ink.honp.core.http.interceptor.OkHttpLogInterceptor;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.client.WxClient;
import ink.honp.wx.core.executor.WxGetRequestExecutor;
import ink.honp.wx.core.executor.WxPostRequestExecutor;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import ink.honp.wx.core.handler.WxSimpleResponseHandler;
import lombok.Getter;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jeff chen
 * @since 2024-01-01 22:07
 */
@Getter
public abstract class WxAbstractClientImpl implements WxClient {

    private static final Integer TIMEOUT = 2 * 60;

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(new OkHttpLogInterceptor(getClientTag(), OkHttpLogInterceptor.Level.BASIC))
            .build();

    private final WxGetRequestExecutor defaultGetExecutor = new WxGetRequestExecutor(this.okHttpClient);
    private final WxPostRequestExecutor defaultPostExecutor = new WxPostRequestExecutor(this.okHttpClient);
    private final WxSimpleResponseHandler responseHandler = new WxSimpleResponseHandler();

    @Override
    public String get(String url, Object queryParams) {
        return execute(defaultGetExecutor, url, queryParams, responseHandler);
    }

    @Override
    public <T> T get(String url, Object queryParams, Class<T> repClz) {
        String result = execute(defaultGetExecutor, url, queryParams, responseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    @Override
    public <T> List<T> getList(String url, Object queryParams, Class<T> repClz) {
        String result = execute(defaultGetExecutor, url, queryParams, responseHandler);
        if (StringUtils.isBlank(result)) {
            return Collections.emptyList();
        }
        return JacksonUtil.toList(result, repClz);
    }

    @Override
    public String post(String url, Object data) {
        return execute(defaultPostExecutor, url, data, responseHandler);
    }

    @Override
    public <T> T post(String url, Object data, Class<T> repClz) {
        String result = execute(defaultPostExecutor, url, data, responseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    @Override
    public <T> T post(String url, Object data, WxResponseHandler<T> responseHandler) {
        return execute(defaultPostExecutor, url, data, responseHandler);
    }

    /**
     * 底层请求方法，若无服务实现所需要方法，则可以使用该方法请求微信 API
     * @param executor      请求执行器
     * @param url           请求地址
     * @param data          请求数据
     * @param responseHandler 结果处理
     * @param <T> 结果类型
     * @return -
     */
    public abstract <T> T execute(WxRequestExecutor executor, String url, Object data, WxResponseHandler<T> responseHandler);

    /**
     * 获取客户端 tag
     * @return -
     */
    public abstract String getClientTag();

    @Override
    public void setOkHttpClient(OkHttpClient httpClient) {
        this.okHttpClient = httpClient;
    }
}
