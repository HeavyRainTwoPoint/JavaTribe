package com.javatribe.apishare.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/20 18:27
 */

public class HeaderInterceptor implements HandlerInterceptor {
    private static final String OPTIONS_METHOD = "OPTIONS";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置请求头过滤器
        //TODO
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, PATCH, OPTIONS");
        response.setHeader("Cache-Control", "no-cache");
        String method = request.getMethod();
        if (OPTIONS_METHOD.equals(method)) {
            response.setStatus(200);
        }
        return true;
    }
}
