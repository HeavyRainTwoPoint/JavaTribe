package com.javatribe.cooperation.bean.dto;

import javax.servlet.http.HttpServletResponse;

/**
 * 常用返回类型
 *
 * @author LCW
 * @since 2021/2/28 10:18
 **/
public class ApiResults {
    public static ApiResult success(Object data) {
        return new ApiResult(HttpServletResponse.SC_OK, "Success", data);
    }

    public static ApiResult success() {
        return new ApiResult(HttpServletResponse.SC_OK, "Success", null);
    }

    public static ApiResult timeout() {
        return new ApiResult(HttpServletResponse.SC_REQUEST_TIMEOUT, "Token expired", null);
    }

    public static ApiResult badRequest(String msg) {
        return new ApiResult(HttpServletResponse.SC_BAD_REQUEST, msg, null);
    }

    public static ApiResult forbidden(String msg) {
        return new ApiResult(HttpServletResponse.SC_FORBIDDEN, "permission denied", null);
    }

    public static ApiResult serverError() {
        return new ApiResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "server Error", null);
    }

}
