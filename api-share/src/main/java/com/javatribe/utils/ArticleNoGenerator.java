package com.javatribe.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/15 14:06
 * 工具类
 */

public final class ArticleNoGenerator {
    /**
     * 生成一个由数字组成的随机字符串作为一篇文章的artNo
     * @return
     */
    public static String createNo(){
        return RandomStringUtils.randomNumeric(8);
    }
}
