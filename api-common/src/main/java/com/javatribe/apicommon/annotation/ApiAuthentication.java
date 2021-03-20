package com.javatribe.apicommon.annotation;

import java.lang.annotation.*;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 16:19
 * @description C端鉴权注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiAuthentication {
}
