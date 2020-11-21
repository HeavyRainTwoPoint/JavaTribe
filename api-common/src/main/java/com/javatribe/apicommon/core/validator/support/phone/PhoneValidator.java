package com.javatribe.apicommon.core.validator.support.phone;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @Author lyr
 * @create 2020/10/12 20:55
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    private static final Pattern PATTERN= Pattern.compile( "^1[345678]\\d{9}$");
    // private static final Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
    // private static final Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的

    /**
     * 验证手机号
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s)) {
            return false;
        } else {
            return PATTERN.matcher(s).matches();

        }
    }
}
