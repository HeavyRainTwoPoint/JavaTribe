package com.javatribe.apienroll.common;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/7 16:29
 * @description
 */
public enum Direction {
    QIAN_DUAN(1,"前端"),
    HOU_DUAN(2,"后端组"),
    SHE_JI(3,"设计组"),
    SUAN_FA(4,"算法组"),
    CHAN_PIN(5,"产品组"),
    AN_ZHUO(6,"安卓组")
    ;

    Direction(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    // 方向代号（1 前端 2 后端 3 设计 4算法 5产品 6安卓）
    private Integer code;
    private String name;
}
