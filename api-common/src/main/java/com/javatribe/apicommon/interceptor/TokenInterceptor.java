package com.javatribe.apicommon.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.ApiAuthentication;
import com.javatribe.apicommon.annotation.SuperAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.interceptor.role.UserType;
import com.javatribe.apicommon.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 16:21
 * @description
 */
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            logger.info("拦截了方法-->{}", ((HandlerMethod) handler).getMethod().getName());

            ApiAuthentication apiAuthentication = handlerMethod.getMethodAnnotation(ApiAuthentication.class);
            AdminAuthentication adminAuthentication = handlerMethod.getMethodAnnotation(AdminAuthentication.class);
            TokenFreeAnnotation tokenFreeAnnotation = handlerMethod.getMethodAnnotation(TokenFreeAnnotation.class);
            SuperAuthentication superAuthentication = handlerMethod.getMethodAnnotation(SuperAuthentication.class);

            //获取请求头里的token
            String token = request.getHeader(JwtUtil.TOKEN_HEADER);

            // 免token调用的接口，放行
            if (tokenFreeAnnotation != null) {
                return true;
            } else if (superAuthentication != null) { // 超级管理员调用
                // 查看是不是超级管理员
                if (JwtUtil.verify(token, UserType.SUPER)) return true;
            } else if (adminAuthentication != null) { // 普通管理员调用
                if (JwtUtil.verify(token, UserType.ADMIN)) return true;
            } else if (apiAuthentication != null) {  // 普通登录用户
                if (JwtUtil.verify(token, UserType.USER)) return true;
            }
        }
        return false;
    }
}