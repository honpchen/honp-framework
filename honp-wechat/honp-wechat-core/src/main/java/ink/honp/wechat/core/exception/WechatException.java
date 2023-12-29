package ink.honp.wechat.core.exception;

import ink.honp.core.exception.BaseException;

/**
 * @author jeffchen
 * date    2023/12/29 16:59
 */
public class WechatException extends BaseException {
    private static final long serialVersionUID = -5968166855697577084L;

    public WechatException(Integer errcode, String errmsg) {
        super(String.valueOf(errcode), errmsg);
    }
}
