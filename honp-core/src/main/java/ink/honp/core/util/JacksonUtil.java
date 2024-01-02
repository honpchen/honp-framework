package ink.honp.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * JSON 工具类
 * @author jeffchen
 * date    2023/11/28 16:35
 */
@Slf4j
@UtilityClass
public class JacksonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * json 字符内容转对象
     * @param text  字符内容
     * @param clz   对象 Class
     * @return 转换失败返回 null
     */
    public static <T> T toBean(final String text, @NonNull Class<T> clz) {
        if (StringUtils.isNotBlank(text)) {
            try {
                return MAPPER.readValue(text, clz);
            } catch (JsonProcessingException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("JSON 字符串格式错误 -> {}", text);
                }
                handleProcessingException(ex);
            }
        }

        return null;
    }

    /**
     * 对象转 json 字符内容
     * @param obj 对象
     * @return json 字符串，失败返回 -> ""
     */
    public static String toJson(Object obj) {
        if (Objects.nonNull(obj)) {
            try {
                return MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException ex) {
                handleProcessingException(ex);
            }
        }
        return StringUtils.EMPTY;
    }

    /**
     * 读取 json 字符串，返回 JsonNode 对象
     * @param jonsText json 字符串
     * @return JsonNode 对象
     */
    public static JsonNode readTree(String jonsText) {
        if (StringUtils.isBlank(jonsText)) {
            return null;
        }
        try {
            return MAPPER.readTree(jonsText);
        } catch (JsonProcessingException ex) {
            handleProcessingException(ex);
        }
        return null;
    }

    private static void handleProcessingException(JsonProcessingException ex) {
        log.warn("Json process error", ex);
    }

    private void objectMapperConfig() {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 取消默认转换timestamps形式
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        // 忽略空Bean转json的错误
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        // 忽略在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        // 支持 java.time.LocalDateTime 类型
        MAPPER.registerModule(new JavaTimeModule());
    }
}
