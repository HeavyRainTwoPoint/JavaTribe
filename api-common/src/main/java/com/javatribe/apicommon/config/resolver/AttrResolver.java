package com.javatribe.apicommon.config.resolver;


import com.alibaba.fastjson.JSONObject;

import com.javatribe.apicommon.core.annontation.AttrData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;


/**
 * @Author lyr
 * @create 2020/9/17 11:44
 */
@Slf4j
@Component
@Lazy
public class AttrResolver implements HandlerMethodArgumentResolver {
    // private static String TOKEN_STR = "token";
    // private static final String TOKEN_HEADER = "token";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AttrData.class) ;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        Class<?> clazz = parameter.getParameterType();
        JSONObject map = new JSONObject();
        for (Field f: clazz.getDeclaredFields()) {
            // System.out.println(f.getName());
            map.put(f.getName(),request.getAttribute(f.getName()));
        }

        return map.toJavaObject(clazz);


        // return webData;
    }
}
