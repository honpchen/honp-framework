package ink.honp.wx.core.exception;

import ink.honp.core.exception.BaseException;

/**
 * @author jeff chen
 * @since 2023-12-31 22:57
 */
public class WxException extends BaseException {

    public WxException(Integer code, String message) {
        super(String.valueOf(code), message);
    }
}
