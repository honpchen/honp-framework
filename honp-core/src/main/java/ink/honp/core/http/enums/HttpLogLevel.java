package ink.honp.core.http.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jeff chen
 * @since 2024-01-07 15:19
 */
@Getter
@AllArgsConstructor
public enum HttpLogLevel {

    /**
     * 不输出日志
     */
    NONE("none"),

    /**
     * 只输出 http 请求地址
     */
    BASIC("basic"),

    /**
     * 只输出 http 请求地址和头部
     */
    HEADERS("headers"),

    /**
     * 输出 http 请求地址，头部和请求体
     */
    BODY("body");

    private final String code;
}
