package com.javatribe.apicommon.dto;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:59
 * @description
 */
public enum ResponseStatus {
    SUCCESS(1000,"成功"),
    ERROR(5000,"系统出错"),
    OSS_ERROR(6000,"上传服务器出错"),
    PARAMS_ERROR(6000,"参数不合法"),
    FILE_DOWNLOAD_ERROR(7000,"文件下载失败"),
    COMMAND_ERROR(8000,"操作失败"),
    ;

    public Integer status;
    public String message;

    ResponseStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
