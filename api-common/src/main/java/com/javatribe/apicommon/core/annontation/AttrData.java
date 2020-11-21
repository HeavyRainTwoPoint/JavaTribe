package com.javatribe.apicommon.core.annontation;

import java.lang.annotation.*;

/**
 * 通过反射 获取 request attribute 的 数据
 * @Author lyr
 * @create 2020/9/17 11:46
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface AttrData {
}
