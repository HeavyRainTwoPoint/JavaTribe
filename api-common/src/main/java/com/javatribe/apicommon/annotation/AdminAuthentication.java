package com.javatribe.apicommon.annotation;

import java.lang.annotation.*;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 16:16
 * @description 管理端鉴权接口
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminAuthentication {
}
