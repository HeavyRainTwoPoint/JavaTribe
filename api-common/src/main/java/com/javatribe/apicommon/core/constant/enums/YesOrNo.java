package com.javatribe.apicommon.core.constant.enums;

/**
 * 表示 是和否的枚举
 * @Author lyr
 * @create 2020/9/29 20:20
 */
public enum YesOrNo {
    /**
     * 表否定关系
     */
    NO(0,"N"),
    /**
     * 表确认关系
     */
    YES(1,"Y");

    /**
     * number类型 ,0为否，1位 是
     */
    public final Integer type;
    /**
     * 字符串类型，N,和 Y
     */
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
