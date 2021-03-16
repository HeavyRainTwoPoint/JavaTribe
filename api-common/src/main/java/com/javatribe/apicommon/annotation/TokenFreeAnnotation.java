package com.javatribe.apicommon.annotation;

import java.lang.annotation.*;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 16:31
 * @description 免token可访问
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenFreeAnnotation {
}
