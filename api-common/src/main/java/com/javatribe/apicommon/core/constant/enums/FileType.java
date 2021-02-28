package com.javatribe.apicommon.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 15:42
 * @description 文件类型
 */
@AllArgsConstructor
@Getter
public enum FileType {
    IMAGE(1, "images"),  // 图片类型
    ZIP(2, "zip");  // 压缩文件类型

    int type;
    String typeName;
}
