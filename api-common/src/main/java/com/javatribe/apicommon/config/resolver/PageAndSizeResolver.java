package com.javatribe.apicommon.config.resolver;


import com.javatribe.apicommon.core.annontation.Page;
import com.javatribe.apicommon.core.annontation.Size;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lyr
 * @create 2020/9/17 22:55
 */
@Lazy
@Component
public class PageAndSizeResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        return methodParameter.hasParameterAnnotation(Page.class) || methodParameter.hasParameterAnnotation(Size.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest)nativeWebRequest.getNativeRequest();
        if(methodParameter.hasParameterAnnotation(Page.class)) {
            Page mark = methodParameter.getParameterAnnotation(Page.class);
            String val = request.getParameter(mark.param());
            if(val==null) {
                return mark.defaultValue();
            }
            int t = Integer.parseInt(val);
            return t<=0?mark.defaultValue():t;
        }else{
            Size mark = methodParameter.getParameterAnnotation(Size.class);
            String val = request.getParameter(mark.param());
            if(val==null) {
                return mark.defaultValue();
            }
            int l = Integer.parseInt(val);

            return l<=0?mark.defaultValue():l;
        }
    }
}
