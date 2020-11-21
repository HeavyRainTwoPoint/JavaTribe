package com.javatribe.apicommon.core.annontation;

import java.lang.annotation.*;

/**
 * @Author lyr
 * @create 2020/9/17 22:52
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Size {
    String param() default "size";
    int defaultValue() default 10;
}
