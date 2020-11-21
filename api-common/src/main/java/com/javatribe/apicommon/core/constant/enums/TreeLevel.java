package com.javatribe.apicommon.core.constant.enums;

/**
 * 树形结构常用枚举
 * @Author lyr
 * @create 2020/9/29 20:34
 */

public enum TreeLevel {
    ROOT(0, "根节点"),
    ONE(1, "一级分类"),
    TWO(2, "二级分类"),
    THREE(3, "三级分类");

    /**
     * number类型
     */
    public final Integer level;
    /**
     * 字符串类型
     */
    public final String value;

    TreeLevel(Integer level, String value) {
        this.level = level;
        this.value = value;
    }
}
