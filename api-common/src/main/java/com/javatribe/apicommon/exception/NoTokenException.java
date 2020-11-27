package com.javatribe.apicommon.exception;


import com.javatribe.apicommon.core.constant.enums.ApiInfo;

/**
 * 没有 token 异常
 * @Author lyr
 * @create 2020/10/31 12:35
 */
public class NoTokenException extends ServiceException{
    public NoTokenException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public NoTokenException(String message, int code, String message1) {
        super(message, code, message1);
    }

    public NoTokenException(ApiInfo info) {
        super(info);
    }
}
