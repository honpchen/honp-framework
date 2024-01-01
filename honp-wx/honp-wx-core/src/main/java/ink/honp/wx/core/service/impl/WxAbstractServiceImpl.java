package ink.honp.wx.core.service.impl;

import ink.honp.core.http.interceptor.OkHttpLogInterceptor;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.executor.WxSimpleGetRequestExecutor;
import ink.honp.wx.core.executor.WxSimplePostRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import ink.honp.wx.core.handler.WxSimpleResponseHandler;
import ink.honp.wx.core.service.WxService;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author jeff chen
 * @since 2024-01-01 22:07
 */
public abstract class WxAbstractServiceImpl implements WxService {

    private static final Integer TIMEOUT = 2 * 60;
    private static final String DEFAULT_TAG = "WX";

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(new OkHttpLogInterceptor(DEFAULT_TAG, OkHttpLogInterceptor.Level.BASIC))
            .build();

    private final WxSimpleGetRequestExecutor defaultGetExecutor = new WxSimpleGetRequestExecutor(this.okHttpClient);
    private final WxSimplePostRequestExecutor defaultPostExecutor = new WxSimplePostRequestExecutor(this.okHttpClient);
    private final WxSimpleResponseHandler defaultResponseHandler = new WxSimpleResponseHandler();

    @Override
    public String get(String url, Object queryParams) {
        return execute(defaultGetExecutor, url, queryParams, defaultResponseHandler);
    }

    @Override
    public <T> T get(String url, Object queryParams, Class<T> repClz) {
        String result = execute(defaultGetExecutor, url, queryParams, defaultResponseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    @Override
    public <T> T post(String url, Object data, Class<T> repClz) {
        String result = execute(defaultPostExecutor, url, data, defaultResponseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    /**
     * 底层请求方法，若无服务实现所需要方法，则可以使用该方法请求微信 API
     * @param executor      请求执行器
     * @param url           请求地址
     * @param data          请求数据
     * @param responseHandler 结果处理
     * @param <E> 请求参数类型
     * @param <R> 结果类型
     * @return -
     */
    public abstract <E, R> R execute(WxRequestExecutor<E, R> executor, String url, E data, WxResponseHandler<R> responseHandler);


    @Override
    public OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    @Override
    public void setOkHttpClient(OkHttpClient httpClient) {
        this.okHttpClient = httpClient;
    }
}
