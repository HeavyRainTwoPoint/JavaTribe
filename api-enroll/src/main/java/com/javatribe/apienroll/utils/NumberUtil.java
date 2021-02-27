package com.javatribe.apienroll.utils;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 16:04
 * @description
 */
public class NumberUtil {
    public static boolean isInValidNum(Integer intNum) {
        return intNum < 0 || intNum == null;
    }

    public static boolean isInValidNum(Long longNum) {
        return longNum < 0 && longNum == null;
    }
}
