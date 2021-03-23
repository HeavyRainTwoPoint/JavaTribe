package com.javatribe.apicompetition.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @Author lyr
 * @create 2021/3/23 13:39
 */
public class OssFileUtil {
    /**
     * 上传 oss 的 文件名字
     * @param fileName
     * @return
     */
    public static String getNewFileName(String fileName) {
        return IdUtil.simpleUUID()+fileExtName(fileName);
    }

    public static String fileExtName(String name) {
        if (StrUtil.isBlank(name)) {
            throw new RuntimeException("it is blank str");
        }
        return name.substring(name.lastIndexOf(".") + 1);
    }

}
