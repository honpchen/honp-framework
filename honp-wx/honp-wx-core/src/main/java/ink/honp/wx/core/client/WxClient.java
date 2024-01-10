package ink.honp.wx.core.client;

import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.util.http.convert.AbstractResponseConverter;
import ink.honp.wx.core.util.http.convert.ResponseConverter;
import ink.honp.wx.core.util.http.executor.RequestExecutor;
import okhttp3.Response;

/**
 * @param <R> Http 执行返回类型
 * @param <H> Http 客户端类型
 * @author jeff chen
 * @since 2023-12-31 22:56
 */
public interface WxClient<R, H> {

    /**
     * 获取access_token
     *
     * @param forceRefresh 是否强制刷新
     * @return accessToken
     */
    String getAccessToken(boolean forceRefresh);

    String get(String url, Object queryParams);

    <T> T get(String url, Object queryParams, Class<T> repClz);

    String post(String url, Object data);

    <T> T post(String url, Object data, Class<T> repClz);

    /**
     * 微信请求封装，该执行方法自动拼接 access_token
     * @param executor 请求执行器
     * @param url 请求地址
     * @param data 参数
     * @param repConverter 结果转换
     * @param <T> 返回类型
     * @return -
     * @throws WxException api 请求异常
     */
    <T> T executeWithAccessToken(RequestExecutor<R> executor, String url, Object data,
                                 ResponseConverter<R, T> repConverter) throws WxException;

    /**
     * 微信请求封装
     * @param executor 请求执行器
     * @param url 请求地址
     * @param data 参数
     * @param repConverter 结果转换
     * @param <T> 返回类型
     * @return -
     * @throws WxException api 请求异常
     */
    <T> T execute(RequestExecutor<R> executor, String url, Object data,
                  ResponseConverter<R, T> repConverter) throws WxException;


    H getHttpClient();
}
