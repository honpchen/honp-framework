package ink.honp.wx.cgi.client;

import ink.honp.wx.core.client.WxClient;
import ink.honp.wx.core.executor.WxRequestExecutor;
import ink.honp.wx.core.handler.WxResponseHandler;
import okhttp3.Response;

/**
 * @author jeffchen
 * date    2024/01/09 11:14
 */
public interface WxCgiClient extends WxClient {


    /**
     * 获取 access_token
     * @param forceRefresh 是否强制刷新
     * @return access_token
     */
    String getAccessToken(boolean forceRefresh);

    /**
     * 该执行方法，不会自动添加 token
     * @param executor          请求执行器
     * @param url               请求地址
     * @param data              请求数据
     * @param responseHandler   结果处理
     * @param retryCount        请求次数
     * @param maxRetryCount     最大请求次数
     * @return   -
     * @param <T> -
     */
    <T> T execute(WxRequestExecutor<Response> executor, String url, Object data, WxResponseHandler<T> responseHandler,
                  int retryCount, int maxRetryCount);
}
