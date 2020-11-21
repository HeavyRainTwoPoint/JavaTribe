package com.javatribe.apicommon.core.annontation;


import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/9/17 22:44
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
// @Min(1)
public @interface Page {

    String param() default "page";
    int defaultValue() default 1;
    // @org.springframework.core.annotation.AliasFor(annotation = Min.class)
    // long value() default 1;

}
