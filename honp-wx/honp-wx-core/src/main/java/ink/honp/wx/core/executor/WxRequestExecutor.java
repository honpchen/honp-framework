package ink.honp.wx.core.executor;

import ink.honp.wx.core.exception.WxException;
import ink.honp.wx.core.handler.WxResponseHandler;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:24
 */
public interface WxRequestExecutor<E, R> {

    R execute(String url, E data, WxResponseHandler<R> responseHandler) throws WxException, IOException;
}
