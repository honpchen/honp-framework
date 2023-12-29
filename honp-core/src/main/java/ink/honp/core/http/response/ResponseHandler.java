package ink.honp.core.http.response;

import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

/**
 * @author jeffchen
 * date    2023/12/29 11:10
 */
public interface ResponseHandler <T> {

    /**
     * 处理响应
     * @param response 响应
     * @return  T  返回指定类型
     * @throws IOException -
     */
    Optional<T> handle(Response response) throws IOException;
}
