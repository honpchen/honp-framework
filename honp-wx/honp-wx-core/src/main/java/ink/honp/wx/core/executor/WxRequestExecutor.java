package ink.honp.wx.core.executor;

import okhttp3.Response;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:24
 */
public interface WxRequestExecutor {

    Response execute(String url, Object data) throws IOException;
}
