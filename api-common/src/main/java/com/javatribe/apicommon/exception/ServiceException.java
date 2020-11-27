package com.javatribe.apicommon.exception;

//
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务层 手动抛出的异常
 * @Author lyr
 * @create 2020/10/11 16:14
 */
@Getter
@AllArgsConstructor
public class ServiceException extends RuntimeException{
    int code;
    String message;
    Throwable cause;


    public ServiceException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }
    public ServiceException(ApiInfo info) {
        code = info.getCode();
        message = info.getMessage();
    }

}
