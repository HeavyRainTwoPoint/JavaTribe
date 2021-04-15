package com.javatribe.apicommon.annotation;

import java.lang.annotation.*;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 18:03
 * @description 超级管理员
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SuperAuthentication {
}
