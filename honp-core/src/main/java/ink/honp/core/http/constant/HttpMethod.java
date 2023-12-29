package ink.honp.core.http.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jeff chen
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum HttpMethod {

    GET("get"),
    POST("post"),
    PUT("put"),
    PATCH("patch"),
    DELETE("delete");

    private final String code;
}
