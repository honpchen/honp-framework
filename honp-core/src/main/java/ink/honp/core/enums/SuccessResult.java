package ink.honp.core.enums;

import ink.honp.core.entity.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jeffchen
 * date    2023/12/28 16:30
 */
@Getter
@AllArgsConstructor
public enum SuccessResult implements ResultCode {

    SUCCESS("0", "成功", "Success");

    private final String code;
    private final String message;
    private final String enMessage;

}
