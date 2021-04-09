package com.javatribe.apicommon.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 16:18
 * @description 文件上传返回的结果
 */
@Data
public class FileUploadDTO {
    private String url; // 资源地址
    private String fileTypeName; // 文件类型名称
    private String contentType; // 文件contentType
    private Date uploadDate; // 上传时间
    private String fileName; // 文件名
    private boolean success; // 是否上传成功
}
