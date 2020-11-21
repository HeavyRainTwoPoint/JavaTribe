package com.javatribe.apicommon.shiro.filter;


import cn.hutool.core.util.StrUtil;
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicommon.exception.NoTokenException;
import com.javatribe.apicommon.shiro.entity.JwtToken;
import com.javatribe.apicommon.util.JwtUtils;
import com.javatribe.apicommon.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/10/25 10:00
 */

@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {
    // public static final String header = "token";
    // public static final String ATTR_TOKEN = "___token_jwt";


    /**
     * 拦截器预处理
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //options 请求，直接放行
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            res.setStatus(org.springframework.http.HttpStatus.OK.value());
            return false;
        }

        return super.preHandle(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        //判断请求的请求头是否带上 "Token"

        //如果存在，则进入 executeLogin 方法执行登入，检查 token 是否正确
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            return false;
        }
        // return false;
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true

    }

    /**
     * 阻止自动重定向
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        // Subject subject = this.getSubject(request, response);
        // if (subject.getPrincipal() == null) {
        //     this.saveRequestAndRedirectToLogin(request, response);
        // } else {
        //     String unauthorizedUrl = this.getUnauthorizedUrl();
        //     if (StringUtils.hasText(unauthorizedUrl)) {
        //         WebUtils.issueRedirect(request, response, unauthorizedUrl);
        //     } else {
        //         WebUtils.toHttp(response).sendError(401);
        //     }
        // }

        return false;
    }


    /**
     * 拦截器逻辑
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        //获取TOKEN
        String token = WebUtils.toHttp(request).getHeader("token");
        log.info("token {}", token);
        if (null == token || StrUtil.isBlank(token)) {
            //直接将 no——token 返回给前端
            WebUtil.renderJson((HttpServletResponse) response, Result.of(ApiInfo.NO_TOKEN));
            return false;
        }
        JwtToken jwtToken = JwtUtils.decodeJwtToken(token);
        try {
            log.info("token {}", jwtToken);
            if (jwtToken.isCheckFail()) {
                //没哟token，捕获异常
                throw new NoTokenException(ApiInfo.NO_TOKEN);
            }

            // if(jwtToken.isSuccess()) {
            request.setAttribute("id", jwtToken.getData().get("id"));
            request.setAttribute("role", jwtToken.getData().get("role"));
            log.info("token  {}", jwtToken);
            // }

            //交给 realm 进行判断，并且返回
            getSubject(request, response).login(jwtToken);

            log.info("验证通过 ");
            return true;
        } catch (Exception ex) {
            log.info("出现异常了 {}", ex.getMessage());
            if (jwtToken.isExpire()) {
                //
                WebUtil.renderJson((HttpServletResponse) response, Result.of(ApiInfo.TOKEN_EXPIRED));
            } else {
                WebUtil.renderJson((HttpServletResponse) response, Result.of(ApiInfo.TOKEN_ERROR));
            }
            return false;
        }


    }
}
