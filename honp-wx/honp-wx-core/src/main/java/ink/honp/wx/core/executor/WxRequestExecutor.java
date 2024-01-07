package ink.honp.wx.core.executor;

import java.io.IOException;

/**
 * @author jeff chen
 * @since 2024-01-01 22:24
 */
public interface WxRequestExecutor<R> {

    R execute(String url, Object data) throws IOException;
}
