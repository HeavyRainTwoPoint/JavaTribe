package com.javatribe.apishare.utils;


import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.javatribe.apishare.protocol.UploadStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import static com.alibaba.fastjson.JSONValidator.Type.Array;


/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/17 21:45
 */

public final class AliyunOssUtil {
    private static final Logger logger = LoggerFactory.getLogger(AliyunOssUtil.class);
    /**
     * 博客上传的图片放在article这个文件夹中
     */
    private static final String BASE_FOLDER = "article/";

    /**
     * 单张图片大小上限为5M
     */
    private static final long MAX_SIZE = 5 * 1000 * 1000;

    /**
     * 允许的文件类型
     */
    private static final String[] FILE_TYPES = {"GIF", "JPG", "JPEG", "PNG"};

    /**
     * 将原先的文件名替换为时间序列
     * @param fileType
     * @return
     */
    private static String getNewFileName(String fileType){
        DateTime dateTime = new DateTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BASE_FOLDER);
        stringBuilder.append(dateTime.toString("yyyyMMddHHmmss"));
        stringBuilder.append(getMillTime(dateTime));
        stringBuilder.append(".");
        stringBuilder.append(fileType);
        return stringBuilder.toString();
    }

    /**
     * 获取格式化之后剩下的毫秒值
     * @param dateTime
     * @return
     */
    private static long getMillTime(DateTime dateTime){
        long time = dateTime.getTime() % 10000;
        return time;
    }

    /**
     * 上传图片, 根据各种情况返回对应的枚举项
     * @param oss 对象存储客户端对象
     * @param multipartFile 上传的文件
     * @param bucketName oss桶名
     */
    public static UploadStatus uploadImage(OSS oss, MultipartFile multipartFile, String bucketName) {
        if (multipartFile == null || multipartFile.getSize() == 0) {
            return UploadStatus.FILE_ISNULL;
        }
        if (isOverflow(multipartFile.getSize())) {
            return UploadStatus.FILE_SIZE_OVERFLOW;
        }
        String fileName = multipartFile.getOriginalFilename();
        if (fileName == null || "".equals(fileName.trim())) {
            return UploadStatus.FILE_TYPE_NOTMATCH;
        }
        String[] temp = fileName.split("\\.");
        String fileType = temp[temp.length - 1];
        if(!isMatchType(fileType)) {
            return UploadStatus.FILE_TYPE_NOTMATCH;
        }
        String newFileName = getNewFileName(fileType);
        try {
            oss.putObject(bucketName, newFileName, new ByteArrayInputStream(multipartFile.getBytes()));
        } catch (IOException e) {
            logger.info(e.getLocalizedMessage());
            return UploadStatus.FILEUPLOAD_FAIL;
        }
        UploadStatus uploadStatus = UploadStatus.FILEUPLOAD_SUCCESS;
        uploadStatus.setMessage("/" + newFileName);
        return uploadStatus;
    };

    /**
     * 判断文件大小知否超过上限
     * @param fileSize 文件大小
     * @return
     */
    private static boolean isOverflow(long fileSize) {
        return fileSize > MAX_SIZE ? true : false;
    }

    /**
     * 判断上传的文件类型是否满足条件
     * @param fileType
     * @return
     */
    private static boolean isMatchType(String fileType) {
        fileType = fileType.toUpperCase();
        for (String type : FILE_TYPES) {
            if (type.equals(fileType)) {
                return true;
            }
        }
        return false;
    }

}
