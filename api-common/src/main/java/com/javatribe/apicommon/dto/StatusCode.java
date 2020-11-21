package com.javatribe.apicommon.dto;

/**
 * 常用状态码
 * @deprecated  建议使用 ApiInfo 枚举 代替 StatusCode 状态码，枚举将会更加全面
 *
 * @Author lyr
 * @create 2020/7/14 0:53
 */
@Deprecated
public class StatusCode {
    /**
     * ok
     */
    public static final int OK = 200;
    /**
     * 出错
     */
    public static final int ERROR = 500;

    /**
     * 服务运行错误
     */
    public static final int SERVICE_ERROR = 505;
    /**
     * 找不到资源
     */
    public static final int GET_LOST = 404;

    /**
     * 没有权限
     */
    public static final int  INSUFFICIENT_PERMISSIONS = 401;

    /**
     * 客户端错误，服务拒绝
     */
    public static final int FORBIDDEN = 403;

    /**
     * 语法错误
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 无token
     */
    public static final int NO_TOKEN = 1000;
    /**
     * token过期
     */
    public static final int TOKEN_EXPIRE = 1001;

    /**
     * 新用户
     */
    public static final int NEW_USER = 1002;


}
