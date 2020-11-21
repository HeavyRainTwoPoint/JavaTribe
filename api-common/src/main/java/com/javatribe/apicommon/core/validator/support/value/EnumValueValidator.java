package com.javatribe.apicommon.core.validator.support.value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author lyr
 * @create 2020/11/3 21:02
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue,Object> {
    Set<String> enumValues = null;
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o==null) {
            //首先不能为 null
            return false;
        }
        if(o instanceof Iterable) {
            //可迭代对象
            for(Object el: (Iterable<?>) o) {
                if(!enumValues.contains(el.toString())) {
                    //如果 不在限定范围，返回false
                    return false;
                }
            }
        }else if (o.getClass().isArray()) {
            //是数组
            int len = Array.getLength(o);
           for (int i=0;i<len;++i) {
               String s = (Array.get(o,i)).toString();
               if(!enumValues.contains(s)) {
                   //如果不包含，返回 false
                   return false;
               }
           }

        }else{
            //不是数组，也不是集合，那么判断为 String,Integer 等单值类型
            return enumValues.contains(o.toString());
        }
        //都在限定范围 ，返回 true
        return true;
    }

    @Override
    public void initialize(EnumValue constraintAnnotation) {

        String[] s = constraintAnnotation.mustAllIn();
        enumValues = new HashSet<>();
        if(s.length > 0) {
            enumValues.addAll(Arrays.asList(s));
        }
    }
}
