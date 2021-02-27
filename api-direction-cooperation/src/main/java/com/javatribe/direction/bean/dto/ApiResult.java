package com.javatribe.direction.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;

/**
 * 返回封装类
 */
@AllArgsConstructor
@Data
@ToString
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;

    public static ApiResult success(Object data) {
        return new ApiResult(HttpServletResponse.SC_OK, "Success", data);
    }

    public static ApiResult success() {
        return new ApiResult(HttpServletResponse.SC_OK, "Success", null);
    }

    public static ApiResult timeout() {
        return new ApiResult(HttpServletResponse.SC_REQUEST_TIMEOUT, "Token expired", null);
    }

    public static ApiResult forbidden(String msg) {
        return new ApiResult(HttpServletResponse.SC_FORBIDDEN, msg, null);
    }

    public static ApiResult serverError() {
        return new ApiResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "server Error", null);
    }
}
