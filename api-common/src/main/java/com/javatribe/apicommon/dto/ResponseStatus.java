package com.javatribe.apicommon.dto;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:59
 * @description
 */
public enum ResponseStatus {
    SUCCESS(1000,"成功"),
    ERROR(5000,"系统出错")
    ;

    public Integer status;
    public String message;

    ResponseStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
