package com.javatribe.apicommon.interceptor.role;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/11 19:26
 * @description  用户类型
 */
public enum UserType {
    USER(1,"USER"), // 普通已登录用户
    ADMIN(2,"ADMIN"), // 管理员
    SUPER(3,"SUPER") // 超级管理员
    ;

    private int typeCode;
    private String type;

    UserType(int typeCode, String type) {
        this.typeCode = typeCode;
        this.type = type;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public String getType() {
        return type;
    }
}
