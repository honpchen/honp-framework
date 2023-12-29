package ink.honp.core.entity;

/**
 * @author jeffchen
 * date    2023/11/28 15:00
 */
public interface ResultCode {

    /**
     * 错误码
     */
    String getCode();

    /**
     * 错误信息
     */
    String getMessage();

    /**
     * 返回英语提示
     */
    String getEnMessage();
}
