package ink.honp.wx.core.crypt;

import ink.honp.wx.core.entity.WxEncryptMsg;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 * @author jeffchen
 * date    2024/01/03 15:43
 */
@Slf4j
@UtilityClass
public class XMLParse {

    private static final String TO_USER_NAME = "ToUserName";
    private static final String ENCRYPT = "Encrypt";

    private static final String XML_MESSAGE_PATTERN = "<xml>\n"
            + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
            + "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
            + "<TimeStamp>%3$s</TimeStamp>\n"
            + "<Nonce><![CDATA[%4$s]]></Nonce>\n"
            + "</xml>";

    /**
     * 提取出xml数据包中的加密消息
     * <xml>
     * <ToUserName></ToUserName>
     * <Encrypt></Encrypt>
     * </xml>
     * @param xmlText 待提取的xml字符串
     * @return 提取出的加密消息字符串
     */
    public static WxEncryptMsg extract(String xmlText) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xmlText);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            return new WxEncryptMsg()
                    .setEncrypt(root.getElementsByTagName(ENCRYPT).item(0).getTextContent())
                    .setToUserName(root.getElementsByTagName(TO_USER_NAME).item(0).getTextContent());
        } catch (Exception e) {
            log.error("XML extract [{}] err.", xmlText, e);
        }
        return null;
    }

    /**
     * 生成xml消息
     * @param encrypt 加密后的消息密文
     * @param signature 安全签名
     * @param timestamp 时间戳
     * @param nonce 随机字符串
     * @return 生成的xml字符串
     */
    public static String generate(String encrypt, String signature, String timestamp, String nonce) {
        return String.format(XML_MESSAGE_PATTERN, encrypt, signature, timestamp, nonce);
    }
}
