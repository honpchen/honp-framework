package ink.honp.core.exception;

import lombok.experimental.UtilityClass;

/**
 * @author jeffchen
 * date    2024/01/03 16:28
 */
@UtilityClass
public class Assert {

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalParameterException(message);
        }
    }
}
