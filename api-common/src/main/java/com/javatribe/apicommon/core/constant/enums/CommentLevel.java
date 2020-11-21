package com.javatribe.apicommon.core.constant.enums;

/**
 * 评论枚举
 * @Author lyr
 * @create 2020/9/29 22:23
 */
public enum CommentLevel {
    GOOD(1, "好评"),

    NORMAL(2, "中评"),

    BAD(3, "差评");

    /**
     * number类型 ,0为否，1位 是
     */
    public final Integer type;
    /**
     * 字符串类型，N,和 Y
     */
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
