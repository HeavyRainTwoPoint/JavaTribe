package com.javatribe.apishare.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 大雨两点
 * 父标签枚举类
 */

@Getter
@AllArgsConstructor
public enum TagLevel {
    /**
     * 前端，等级：父标签
     */
    TAG_FRONTEND("前端", 1),
    /**
     * 后端，等级：父标签
     */
    TAG_REAREND("后端", 2),
    /**
     * 设计，等级：父标签
     */
    TAG_DESIGN("设计", 3),
    /**
     * 产品，等级：父标签
     */
    TAG_PRODUCT("产品", 4),
    /**
     * 算法，等级：父标签
     */
    TAG_ALGORITHM("算法", 5),
    /**
     * 安卓，等级：父标签
     */
    TAG_ANDROID("安卓", 6);

    String tagName;
    int id;

}
