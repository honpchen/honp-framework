package ink.honp.wx.core.util.http.executor;

import java.io.IOException;

/**
 * 请求接口
 * @param <T> 返回值
 * @author jeff chen
 * @since 2024-01-01 22:24
 */
public interface RequestExecutor<T> {

    T execute(String url, Object data) throws IOException;
}
