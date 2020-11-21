package com.javatribe.apicommon.core.constant.enums;

/**
 * @Author lyr
 * @create 2020/9/29 20:24
 */
public enum SexType {
    /**
     * 表否定关系
     */
    WOMAN(0,"女"),
    /**
     * 表确认关系
     */
    MAN(1,"男"),
    /**
     * 保密
     */
    SECRET(2,"保密");

    /**
     * number类型
     */
    public final Integer type;
    /**
     * 字符串类型
     */
    public final String value;

    SexType(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
