package com.javatribe.cooperation.exceptions;

import com.javatribe.cooperation.bean.dto.ApiResult;
import com.javatribe.cooperation.bean.dto.ApiResults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author LCW
 * @since 2021/2/28 11:04
 **/
@ControllerAdvice
@Slf4j
public class GlobalException extends Exception {

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public ApiResult exceptionHandler(Throwable throwable, HttpServletResponse response) {
        log.error("api异常===" + throwable);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return ApiResults.serverError();
    }
}
