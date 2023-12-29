package ink.honp.core.exception;

import ink.honp.core.enums.CommonError;

/**
 * 加解密异常
 * @author jeffchen
 * date    2023/11/29 14:52
 */
public class CryptoException extends BaseException {

    public CryptoException(String message) {
        super(CommonError.INTERNAL_SERVER_ERROR.getCode(), message);
    }
}
