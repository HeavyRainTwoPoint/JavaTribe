package com.javatribe.apicommon.exception;

// import com.itshare.video.common.core.constant.enums.ApiInfo;

import com.javatribe.apicommon.core.constant.enums.ApiInfo;

/**
 * @Author lyr
 * @create 2020/11/10 23:22
 */
public class RequestBodyErrorException extends ServiceException{
    public RequestBodyErrorException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public RequestBodyErrorException(String message, int code, String message1) {
        super(message, code, message1);
    }

    public RequestBodyErrorException(ApiInfo info) {
        super(info);
    }
}
