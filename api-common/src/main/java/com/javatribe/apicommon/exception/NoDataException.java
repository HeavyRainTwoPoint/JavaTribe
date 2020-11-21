package com.javatribe.apicommon.exception;


import com.javatribe.apicommon.core.constant.enums.ApiInfo;

/**
 * 没有响应的数据
 * @Author lyr
 * @create 2020/11/1 17:23
 */
public class NoDataException extends ServiceException{
    public NoDataException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public NoDataException(String message, int code, String message1) {
        super(message, code, message1);
    }

    public NoDataException(ApiInfo info) {
        super(info);
    }
}
