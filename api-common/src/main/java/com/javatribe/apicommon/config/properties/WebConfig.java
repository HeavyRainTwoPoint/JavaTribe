package com.javatribe.apicommon.config.properties;

import com.javatribe.apicommon.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/20 11:03
 * @description
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，拦截所有访问路径
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/admin/**")
        .excludePathPatterns("/home/**")
        .excludePathPatterns("/dist2/**");


    }
}
