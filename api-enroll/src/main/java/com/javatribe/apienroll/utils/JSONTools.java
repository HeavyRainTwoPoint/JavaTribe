package com.javatribe.apienroll.utils;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/2 22:42
 * @description
 */
public class JSONTools {
    public static <T> List<T> toList(JSONArray jsonArray, Class<T> elementType) {
        return JSONUtil.toList(jsonArray,elementType);
    }

}
