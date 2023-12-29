package ink.honp.core.annotation;

import java.lang.annotation.*;

/**
 * 重复提交注解
 * @author jeffchen
 * date    2023/11/28 18:06
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

    /**
     * 间隔时间(ms), 小于该时间为重复提交
     */
    int interval() default 5000;

    String message() default "Repeat submit";
}
