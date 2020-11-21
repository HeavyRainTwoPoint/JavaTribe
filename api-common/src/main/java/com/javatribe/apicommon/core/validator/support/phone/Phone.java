package com.javatribe.apicommon.core.validator.support.phone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/10/12 20:51
 */
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
    String message() default "手机号校验错误";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
}
