package ink.honp.core.util.crypto;

import ink.honp.core.exception.CryptoException;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

/**
 * @author jeff chen
 * @since 1.0.0
 */
@Slf4j
public abstract class RsaUtil {


    private static final String RSA = "RSA";
    private static final int KEY_SIZE = 1024;
    private static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

    private RsaUtil() {

    }

    /**
     * RSA公钥加密
     * @param plaintext 明文
     * @param publicKey 公钥
     * @return 密文
     */
    @SuppressWarnings("all")
    public static String encrypt(String plaintext, String publicKey) throws CryptoException {
        try {
            RSAPublicKey pubKey = (RSAPublicKey) getPublicKey(publicKey);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            return Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception ex) {
            log.warn("RSA 加密异常", ex);
            throw new CryptoException("RSA decrypt exception");
        }
    }

    /**
     * RSA私钥解密
     *
     * @param ciphertext 密文
     * @param privateKey 私钥
     * @return 明文
     */
    @SuppressWarnings("all")
    public static String decrypt(String ciphertext, String privateKey) throws CryptoException {
        try {
            byte[] inputByte = Base64.getDecoder().decode(ciphertext);
            //base64编码的私钥
            RSAPrivateKey priKey = (RSAPrivateKey) getPrivateKey(privateKey);

            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);

            return new String(cipher.doFinal(inputByte));
        }catch (Exception ex) {
            log.warn("RSA 解密异常", ex);
            throw new CryptoException("RSA decrypt exception");
        }
    }


    public static PrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {

        byte[] encodedKey = Base64.getDecoder().decode(privateKey);

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(encodedKey);

        return KeyFactory.getInstance(RSA).generatePrivate(priPKCS8);
    }


    /**
     * <h2>根据本地存储的公钥获取到 PublicKey 对象</h2>
     * */
    public static PublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] encodedKey = Base64.getDecoder().decode(publicKey);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encodedKey);

        return KeyFactory.getInstance(RSA).generatePublic(keySpec);
    }

    /**
     * 随机生成密钥对
     * @return 返回密钥对 publicKey -> publicVal; privateKey -> privateVal
     */
    public static Map<String, String> generateKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);
        // 初始化密钥对生成器
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();

        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        String publicKeyHex = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyHex = Base64.getEncoder().encodeToString(privateKey.getEncoded());

        return Map.of("publicKey", publicKeyHex, "privateKey", privateKeyHex);

    }


}
