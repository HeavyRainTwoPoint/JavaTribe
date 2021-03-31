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
    /**
     * 接口信息
     */
    String message;
    /**
     * 其他信息
     */
    String extraMessage;
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

    public ServiceException(ApiInfo info,String message) {
        code = info.getCode();
        message = info.getMessage();
        //其他信息
        this.extraMessage = message;
    }

}
