package com.javatribe.apienroll.utils;

import java.util.Arrays;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 22:12
 * @description
 */
public class ObjectUtil {
    public static boolean isNull(Object... o) {
        boolean anyMatch = Arrays.stream(o).anyMatch(x -> {
            return x == null;
        });
        return anyMatch;
    }

    public static void main(String[] args) {
        boolean aNull = ObjectUtil.isNull(new ObjectUtil(), new ObjectUtil(), new ObjectUtil());
        System.out.println(aNull);
    }


}
