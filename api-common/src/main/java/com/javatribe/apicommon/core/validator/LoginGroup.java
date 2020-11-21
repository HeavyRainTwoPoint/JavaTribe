package com.javatribe.apicommon.core.validator;

/**
 * validator.validate(bean,LoginGroup.class,QueryGroup.class)
 * 登录验证
 * @Author lyr
 * @create 2020/10/12 20:43
 */
public interface LoginGroup {
    //组排序的用法，耗时的最好验证，
    /*
    *
    * @GroupSequence({
    *   LoginGroup.class,
    *   QueryGroup.class
    *
    * })
    * public interface ComponentGroup{}
    *
    * validator.validate(bean,componentGroup.class)
    *
    * */
    /*
    *
    * 高级约束注解
    *validator.validateParameters()
    * 对方法参数校验
    *
    * 对方法返回值校验
    *
    * validator.validateReturnValue()
    *
    * */


}
