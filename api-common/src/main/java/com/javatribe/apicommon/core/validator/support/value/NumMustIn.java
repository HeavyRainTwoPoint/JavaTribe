package com.javatribe.apicommon.core.validator.support.value;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 注解只能修饰单值
 * @Author lyr
 * @create 2020/10/26 12:05
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumMustInValidator.class)
public @interface NumMustIn {
    int[] anyIn();
    String message() default "参数枚举不符合规范";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
}
