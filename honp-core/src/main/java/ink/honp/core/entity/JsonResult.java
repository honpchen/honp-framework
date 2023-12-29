package ink.honp.core.entity;

import ink.honp.core.enums.SuccessResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jeffchen
 * date    2023/12/28 16:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult <T> {

    private String code;

    private String message;

    private String enMessage;

    private String traceId;

    private T data;

    public JsonResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.enMessage = resultCode.getEnMessage();
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> result = new JsonResult<>(SuccessResult.SUCCESS);
        result.setData(data);

        return result;
    }


}
