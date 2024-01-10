package ink.honp.wx.core.util.crypt;

import ink.honp.core.constant.SymbolicConstant;
import ink.honp.core.exception.Assert;
import ink.honp.wx.core.entity.WxEncryptMsg;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 提供接收和推送给公众平台消息的加解密接口(UTF8编码的字符串)
 * @author jeff chen
 * @since 1.0.0
 */
@Slf4j
public class WxBizMsgCrypt {

    private static final String BASE_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String ENCODING_AES_KEY_REGEX = "^[A-Za-z0-9]{43}$";

    private static final String AES = "AES";
    private static final String AES_CBC_NO_PADDING = "AES/CBC/NoPadding";

    private final Base64 base64 = new Base64();
    private final Random random = new Random();

    private final String appid;
    private final String token;
    private final byte[] aesKey;

    /**
     * @param appid 公众平台appid
     * @param token 公众平台上，开发者设置的token
     * @param encodingAesKey 公众平台上，开发者设置的EncodingAESKey
     */
    public WxBizMsgCrypt(@NonNull String appid, @NonNull String token, @NonNull String encodingAesKey) {
        Assert.isTrue(encodingAesKey.matches(ENCODING_AES_KEY_REGEX), "消息加密密钥由43位字符组成，字符范围为A-Z,a-z,0-9");

        this.appid = appid;
        this.token = token;
        this.aesKey = Base64.decodeBase64(encodingAesKey + SymbolicConstant.EQUAL);
    }


    /**
     * 对明文进行加密.
     *
     * @param text 需要加密的明文
     * @return 加密后base64编码的字符串
     */
    public String encrypt(String randomStr, String text) {
        ByteGroup byteCollector = new ByteGroup();
        byte[] randomStrBytes = randomStr.getBytes(StandardCharsets.UTF_8);
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
        byte[] appidBytes = this.appid.getBytes(StandardCharsets.UTF_8);

        // randomStr + networkBytesOrder + text + appid
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(appidBytes);

        // ... + pad: 使用自定义的填充方式对明文进行补位填充
        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);

        // 获得最终的字节流, 未加密
        byte[] unencrypted = byteCollector.toBytes();

        try {
            // 设置加密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance(AES_CBC_NO_PADDING);
            SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, AES);
            IvParameterSpec iv = new IvParameterSpec(this.aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

            // 加密
            byte[] encrypted = cipher.doFinal(unencrypted);

            // 使用BASE64对加密后的字符串进行编码
            return base64.encodeToString(encrypted);
        } catch (Exception e) {
            log.error("微信消息加密错误", e);
        }
        return null;
    }

    /**
     * 对密文进行解密.
     * @param text 需要解密的密文
     * @return 解密得到的明文
     */
    public String decrypt(String text) {
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance(AES_CBC_NO_PADDING);
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, AES);
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

            // 使用BASE64对密文进行解码
            byte[] encrypted = Base64.decodeBase64(text);

            // 解密
            byte[] original = cipher.doFinal(encrypted);

            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);

            // 分离16位随机字符串,网络字节序和AppId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

            int xmlLength = recoverNetworkBytesOrder(networkOrder);

            String xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), StandardCharsets.UTF_8);
            String fromAppid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), StandardCharsets.UTF_8);

            // appid不相同的情况
            if (!fromAppid.equals(this.appid)) {
                log.warn("WX AES decrypt failure, [fromAppid:{}, appid:{}]", fromAppid, this.appid);
                return null;
            }

            return xmlContent;
        } catch (Exception e) {
            log.error("微信消息解密错误.", e);
        }
        return null;
    }


    /**
     * 将公众平台回复用户的消息加密打包.
     * <ol>
     * 	<li>对要发送的消息进行AES-CBC加密</li>
     * 	<li>生成安全签名</li>
     * 	<li>将消息密文和安全签名打包成xml格式</li>
     * </ol>
     *
     * @param replyMsg 公众平台待回复用户的消息，xml格式的字符串
     * @param timeStamp 时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce 随机串，可以自己生成，也可以用URL参数的nonce
     *
     * @return 加密后的可以直接回复用户的密文，包括msg_signature, timestamp, nonce, encrypt的xml格式的字符串
     */
    public String encryptMsg(String replyMsg, String timeStamp, String nonce) {
        // 加密
        String encrypt = encrypt(getRandomStr(), replyMsg);
        if (StringUtils.isBlank(encrypt)) {
            return null;
        }

        // 生成安全签名
        if (SymbolicConstant.EQUAL.equals(timeStamp)) {
            timeStamp = Long.toString(System.currentTimeMillis());
        }

        String signature = SHA1.gen(this.token, timeStamp, nonce, encrypt);
        if (log.isDebugEnabled()) {
            log.debug("WX signature [{}].", signature);
        }

        // 生成发送的xml
        return XMLParse.generate(encrypt, signature, timeStamp, nonce);
    }

    /**
     * 检验消息的真实性，并且获取解密后的明文.
     * <ol>
     * 	<li>利用收到的密文生成安全签名，进行签名验证</li>
     * 	<li>若验证通过，则提取xml中的加密消息</li>
     * 	<li>对消息进行解密</li>
     * </ol>
     *
     * @param msgSignature 签名串，对应URL参数的msg_signature
     * @param timeStamp 时间戳，对应URL参数的timestamp
     * @param nonce 随机串，对应URL参数的nonce
     * @param postData 密文，对应POST请求的数据
     *
     * @return 解密后的原文
     */
    public String decryptMsg(String msgSignature, String timeStamp, String nonce, String postData) {

        // 密钥，公众账号的app secret
        // 提取密文
        WxEncryptMsg encryptMsg = XMLParse.extract(postData);
        if (Objects.isNull(encryptMsg)) {
            return null;
        }

        // 验证安全签名
        String signature = SHA1.gen(this.token, timeStamp, nonce, encryptMsg.getEncrypt());

        // 和URL中的签名比较是否相等
        if (!signature.equals(msgSignature)) {
            log.warn("WX signature invalid, [signature:{}, msgSignature:{}]", signature, msgSignature);
            return null;
        }

        // 解密
        return decrypt(encryptMsg.getEncrypt());
    }

    /**
     * 验证URL
     * @param msgSignature 签名串，对应URL参数的msg_signature
     * @param timeStamp 时间戳，对应URL参数的timestamp
     * @param nonce 随机串，对应URL参数的nonce
     * @param echoStr 随机串，对应URL参数的echostr
     *
     * @return 解密之后的echostr
     */
    public String verifyUrl(String msgSignature, String timeStamp, String nonce, String echoStr) {
        String signature = SHA1.gen(this.token, timeStamp, nonce, echoStr);

        if (!signature.equals(msgSignature)) {
            log.warn("WX signature invalid, [signature:{}, msgSignature:{}]", signature, msgSignature);
            return null;
        }

        return decrypt(echoStr);
    }



    // 生成4个字节的网络字节序
    private byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    private int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    // 随机生成16位字符串
    private String getRandomStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(BASE_STRING.length());
            sb.append(BASE_STRING.charAt(number));
        }
        return sb.toString();
    }

    private static class ByteGroup {

        private final ArrayList<Byte> byteContainer = new ArrayList<>();

        public byte[] toBytes() {
            byte[] bytes = new byte[byteContainer.size()];
            for (int i = 0; i < byteContainer.size(); i++) {
                bytes[i] = byteContainer.get(i);
            }
            return bytes;
        }

        public void addBytes(byte[] bytes) {
            for (byte b : bytes) {
                byteContainer.add(b);
            }
        }

        public int size() {
            return byteContainer.size();
        }
    }
}
