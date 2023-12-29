package ink.honp.core.util.crypto;

import ink.honp.core.exception.CryptoException;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * MD5 加密工具类
 * @author jeff chen
 * @since 1.0.0
 */
@Slf4j
public abstract class Md5Util {

    private static final String MD5 = "MD5";

    private Md5Util() {

    }

    /**
     * 生成文件摘要，转为16进制输出
     * @param data 数据
     * @return 摘要
     */
    public static String digestHex(String data) {

        return byte2hex(encrypt(data));
    }

    /**
     * byte 数组转 16 进制
     * @param b byte 数组
     * @return 16进制字符串
     */
    public static String byte2hex(byte[] b) {
        StringBuilder hs= new StringBuilder();
        String stmp="";
        for (byte value : b) {
            //为了保证二进制机器数不变，这里需要& 0XFF
            stmp = (Integer.toHexString(value & 0XFF));
            //如果只有一位，需要在前面补上0凑足两位
            if(stmp.length() == 1) {
                hs.append("0").append(stmp);
            }else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }


    public static byte[] encrypt(String encryptStr) throws CryptoException {
        try {
            MessageDigest md5 = MessageDigest.getInstance(MD5);
            md5.update(encryptStr.getBytes(StandardCharsets.UTF_8));
            return md5.digest();
        } catch (Exception ex) {
            log.error("MD5 加密异常" , ex);
            throw new CryptoException("MD5 encrypt exception");
        }
    }
}
