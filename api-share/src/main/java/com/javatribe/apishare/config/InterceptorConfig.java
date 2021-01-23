package com.javatribe.apishare.config;

import com.javatribe.apishare.interceptor.HeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/20 18:25
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 设置请求头的拦截器，拦截所有的请求，除了请求页面的之外
     * 设置抽奖的拦截器，拦截非法登录的请求、无效的请求等
     * 设置登录的拦截器，拦截企图重复登录的请求
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor())
                .addPathPatterns("/share/**")
                .excludePathPatterns("/*.html");
    }
}
