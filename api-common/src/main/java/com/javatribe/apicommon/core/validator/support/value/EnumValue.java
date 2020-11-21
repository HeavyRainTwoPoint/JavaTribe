package com.javatribe.apicommon.core.validator.support.value;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解可以用于集合 ，数组，和 单值修饰
 * @Author lyr
 * @create 2020/11/3 21:01
 */
@Documented
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface EnumValue {
    String[] mustAllIn();
    String message() default "参数枚举不符合规范";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
}
