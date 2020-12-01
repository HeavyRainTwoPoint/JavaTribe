package com.javatribe.apicommon.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 常用 API 状态码
 * @Author lyr
 * @create 2020/10/12 21:49
 */

@Getter
@AllArgsConstructor
public enum ApiInfo {
    BUSINESS_ERROR_BUSY(505, "服务繁忙"),
    BASIC_ERROR(500, "服务运行异常"),


    OK(200, "OK"),

    NO_RESOURCE(404,"找不到资源"),

    BAD_REQUEST(400,"请求报文语法错误[参数校验失败]"),
    FORBIDDEN_REQUEST(403,"没有权限"),

    SERVER_ERROR(500,"服务异常"),
    SERVICE_UN_AVAILABLE(503,"服务不可用"),



    NO_TOKEN(1000, "没有token验证"),
    TOKEN_EXPIRED(1001, "token过期"),

    NEW_USER(1002, "新用户"),
    TOKEN_ERROR(1003,"token验证失败"),

    ACCOUNT_FREEZE(1600,"账号冻结");



    int code;
    String message;

}
