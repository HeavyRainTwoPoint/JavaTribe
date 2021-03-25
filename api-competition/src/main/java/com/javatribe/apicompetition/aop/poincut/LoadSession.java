package com.javatribe.apicompetition.aop.poincut;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.util.JustUserIsLoadUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class LoadSession {

    @Around(value = "@annotation(com.javatribe.apicompetition.aop.annotation.ActionHandler))")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取到请求的属性
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取到请求对象
        HttpServletRequest request = attributes.getRequest();

        boolean load = JustUserIsLoadUtil.userIsLoad(request);

        if (!load){
            Result result = new Result();
            result.setCode(401);
            result.setMessage("用户未登录，请进行登录在继续操作");
            return result;
        }else{
            return joinPoint.proceed();
        }
    }

}
