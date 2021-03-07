package com.javatribe.apienroll.utils;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 16:04
 * @description
 */
public class NumberUtil {
    public static boolean isInValidNum(Integer intNum) {
        return intNum == null || intNum < 0;
    }

    public static boolean isInValidNum(Long longNum) {
        return longNum == null || longNum < 0;
    }
}
