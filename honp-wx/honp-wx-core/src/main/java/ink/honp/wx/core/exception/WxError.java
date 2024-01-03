package ink.honp.wx.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jeffchen
 * date    2024/01/02 17:12
 */
@Getter
@AllArgsConstructor
public enum WxError {

    INVALID_TOKEN("40001", "access_token 无效"),
    ILLEGAL_TOKEN("40014", "不合法的 access_token"),
    TOKEN_TIMEOUT("42001", "access_token 超时"),
    SERVER_ERROR("-1", "系统繁忙"),
    GET_ACCESS_TOKEN_ERROR("-11", "获取 accessToken 失败"),
    CONFIG_ERROR("-12", "配置错误"),
    VALIDATE_SIGNATURE_ERROR("-40001", "签名验证错误"),
    PARSE_XML_ERROR("-40002", "xml 解析失败"),
    COMPUTE_SIGNATURE_ERROR("-40003", "sha 加密生成签名失败"),
    ILLEGAL_AES_KEY("-40004", "SymmetricKey 非法"),
    VALIDATE_APPID_ERROR("-40005", "appid 校验失败"),
    ENCRYPT_AES_ERROR("-40006", "aes 加密失败"),
    DECRYPT_AES_ERROR("-40007", "aes 解密失败"),
    ILLEGAL_BUFFER("-40008", "解密后得到的 buffer 非法");

    private final String code;
    private final String message;

    public static boolean isInvalidToken(String code) {
        return WxError.INVALID_TOKEN.getCode().equals(code)
                || WxError.ILLEGAL_TOKEN.getCode().equals(code)
                || WxError.TOKEN_TIMEOUT.getCode().equals(code);
    }
}
