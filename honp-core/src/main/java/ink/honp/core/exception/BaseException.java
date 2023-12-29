package ink.honp.core.exception;

import ink.honp.core.entity.ResultCode;
import lombok.Getter;

/**
 * 异常基类
 * @author jeffchen
 * date    2023/11/28 15:49
 */
@Getter
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 6065851934584473359L;

    private final String code;

    public BaseException(ResultCode error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public BaseException(ResultCode error, Exception ex) {
        super(error.getMessage(), ex);
        this.code = error.getCode();
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code, String message, Exception ex) {
        super(message, ex);
        this.code = code;
    }
}
