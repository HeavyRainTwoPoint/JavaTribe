package com.javatribe.apicommon.exception;


import com.javatribe.apicommon.core.constant.enums.ApiInfo;

/**
 *服务器 服务繁忙，业务异常
 * @Author lyr
 * @create 2020/10/12 20:38
 */
public class BusinessException extends ServiceException{


    public BusinessException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public BusinessException(String message, int code, String message1) {
        super(message, code, message1);
    }

    public BusinessException(ApiInfo info) {
        super(info);
    }
}
