package com.javatribe.apicommon.core.validator.support.value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @Author lyr
 * @create 2020/10/26 12:09
 */
public class NumMustInValidator implements ConstraintValidator<NumMustIn,Object> {
    int[] mustAnyIn = null;
    @Override
    public void initialize(NumMustIn constraintAnnotation) {
        mustAnyIn = constraintAnnotation.anyIn();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o==null) {
            return false;
        }
        String val = o.toString();
        for (int num: mustAnyIn) {
            if ((String.valueOf(num)).equals(val)) {
                return true;
            }
        }
        return false;
    }
}
