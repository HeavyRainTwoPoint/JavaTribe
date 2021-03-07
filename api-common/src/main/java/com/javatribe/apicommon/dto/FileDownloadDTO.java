package com.javatribe.apicommon.dto;

import lombok.Data;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 16:58
 * @description 文件下载
 */
@Data
public class FileDownloadDTO {
    private InputStream inputStream;
    private OutputStream outputStream;
}
