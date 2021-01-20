package com.javatribe.apishare.protocol;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/19 16:56
 */

@Getter
@AllArgsConstructor
public enum UploadStatus {
    /**
     * 文件为空
     */
    FILE_ISNULL(1011, "文件为空"),

    /**
     * 文件大小超出上限
     */
    FILE_SIZE_OVERFLOW(1012, "文件大小已超过5M上限"),

    /**
     * 非法文件类型
     */
    FILE_TYPE_NOTMATCH(1013, "非法文件类型"),

    /**
     * 文件上传失败
     */
    FILEUPLOAD_FAIL(500, "文件上传失败"),

    /**
     * 文件上传成功
     */
    FILEUPLOAD_SUCCESS(200, "文件已上传");

    int code;
    String message;

    public void setMessage(String message) {
        this.message = message;
    }

}
