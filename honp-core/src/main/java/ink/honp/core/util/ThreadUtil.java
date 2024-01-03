package ink.honp.core.util;

import lombok.experimental.UtilityClass;

/**
 * @author jeffchen
 * date    2024/01/02 18:05
 */
@UtilityClass
public class ThreadUtil {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
