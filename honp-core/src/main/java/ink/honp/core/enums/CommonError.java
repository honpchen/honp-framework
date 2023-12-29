package ink.honp.core.enums;

import ink.honp.core.entity.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jeffchen
 * date    2023/11/28 15:58
 */
@Getter
@AllArgsConstructor
public enum CommonError implements ResultCode {

    ILLEGAL_PARAMETER("400", "非法参数", "Illegal parameter."),
    INTERNAL_SERVER_ERROR("500", "系统繁忙，请稍后再试", "System busy, please try again later."),
    REPEAT_SUBMIT("504", "重复提交", "Repeat submitted"),;

    private final String code;
    private final String message;
    private final String enMessage;
}
