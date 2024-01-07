package ink.honp.wx.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import ink.honp.core.util.JacksonUtil;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author jeff chen
 * @since 2024-01-07 22:27
 */
@UtilityClass
public class WxResponseParseUtil {

    public static String parse(String response, String key) {
        if (StringUtils.isBlank(response)) {
            return StringUtils.EMPTY;
        }

        JsonNode responseNode = JacksonUtil.readTree(response);
        if (Objects.isNull(responseNode)) {
            return StringUtils.EMPTY;
        }
        return responseNode.get(key).asText();
    }
}
