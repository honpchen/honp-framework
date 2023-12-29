package ink.honp.core.exception;

import ink.honp.core.enums.CommonError;

/**
 * 非法参数异常
 * @author jeffchen
 * date    2023/11/28 15:58
 */
public class IllegalParameterException extends BaseException {

    public IllegalParameterException() {
        super(CommonError.ILLEGAL_PARAMETER);
    }

    public IllegalParameterException(String message) {
        super(CommonError.ILLEGAL_PARAMETER.getCode(), message);
    }
}
