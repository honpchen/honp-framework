package ink.honp.wx.core.client.impl;

import ink.honp.core.http.enums.HttpLogLevel;
import ink.honp.core.util.JacksonUtil;
import ink.honp.wx.core.client.WxClient;
import ink.honp.wx.core.executor.WxGetRequestExecutor;
import ink.honp.wx.core.executor.WxPostRequestExecutor;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import ink.honp.wx.core.handler.WxSimpleResponseHandler;
import ink.honp.wx.core.log.WxLogInterceptor;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Response;
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

    private final OkHttpClient okHttpClient;
    private final WxGetRequestExecutor getRequestExecutor;
    private final WxPostRequestExecutor postRequestExecutor;
    private final WxSimpleResponseHandler responseHandler = new WxSimpleResponseHandler();

    protected WxAbstractClientImpl(String clientTag, Integer timeout, HttpLogLevel level) {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS)
                .addInterceptor(new WxLogInterceptor(clientTag, level))
                .build();

        getRequestExecutor = new WxGetRequestExecutor(okHttpClient);
        postRequestExecutor = new WxPostRequestExecutor(okHttpClient);
    }



    @Override
    public String get(String url, Object queryParams) {
        return execute(getRequestExecutor, url, queryParams, responseHandler);
    }

    @Override
    public <T> T get(String url, Object queryParams, Class<T> repClz) {
        String result = execute(getRequestExecutor, url, queryParams, responseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    @Override
    public <T> List<T> getList(String url, Object queryParams, Class<T> repClz) {
        String result = execute(getRequestExecutor, url, queryParams, responseHandler);
        if (StringUtils.isBlank(result)) {
            return Collections.emptyList();
        }
        return JacksonUtil.toList(result, repClz);
    }

    @Override
    public String post(String url, Object data) {
        return execute(postRequestExecutor, url, data, responseHandler);
    }

    @Override
    public <T> T post(String url, Object data, Class<T> repClz) {
        String result = execute(postRequestExecutor, url, data, responseHandler);
        if (StringUtils.isBlank(result)) {
            return null;
        }
        return JacksonUtil.toBean(result, repClz);
    }

    @Override
    public <T> T post(String url, Object data, WxResponseHandler<T> responseHandler) {
        return execute(postRequestExecutor, url, data, responseHandler);
    }

    /**
     * 该执行方法，会自动添加 token
     * @param executor      请求执行器
     * @param url           请求地址
     * @param data          请求数据
     * @param responseHandler 结果处理
     * @param <T> 结果类型
     * @return -
     */
    public abstract <T> T execute(WxRequestExecutor<Response> executor, String url, Object data,
                                  WxResponseHandler<T> responseHandler);
}
