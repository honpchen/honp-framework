package ink.honp.wx.core.handler;

import ink.honp.wx.core.exception.WxException;
import okhttp3.Response;

import java.io.IOException;

/**
 * 响应处理器
 * R 请求返回响应类型
 * @author jeff chen
 * @since 2024-01-01 17:51
 */
public interface WxResponseHandler<T> {

    T handle(Response response) throws WxException, IOException;
}
