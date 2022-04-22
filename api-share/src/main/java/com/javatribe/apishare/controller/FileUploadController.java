package com.javatribe.apishare.controller;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyuncs.OssAcsRequest;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.config.properties.AliOssProperties;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.protocol.UploadStatus;
import com.javatribe.apishare.utils.AliyunOssUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/5/10 19:53
 */

@RestController
@RequestMapping("/share")
public class FileUploadController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private String BASE_FOLDER = "article/";
    @Autowired
    AliOssProperties properties;
    @Autowired
    OSS oss;
    @PostMapping("/upload")
    @TokenFreeAnnotation
    public Result upload(@RequestParam("file")MultipartFile file) {
        logger.info("文件大小：[{}]", file.getSize());
        String message = uploadFile(oss, file, properties.getBucketName());
        return Result.success(properties.getHost() + message);
    }

    public String uploadFile(OSS oss, MultipartFile multipartFile, String bucketName) {
        logger.info("开始上传========>");
        if (multipartFile == null || multipartFile.getSize() == 0) {
            return "false" ;
        }
        String fileName = multipartFile.getOriginalFilename();
        String[] temp = fileName.split("\\.");
        String fileType = temp[temp.length - 1];
        String newFileName = getNewFileName(fileType);
        try {
            oss.putObject(bucketName, newFileName, new ByteArrayInputStream(multipartFile.getBytes()));
        } catch (IOException e) {
//            logger.info(e.getLocalizedMessage());
            logger.info("文件上传出错：{}", e.getMessage());
            logger.info("异常中断==============");
            return "false";
        }
//        UploadStatus uploadStatus = UploadStatus.FILEUPLOAD_SUCCESS;
//        uploadStatus.setMessage("/" + newFileName);
        logger.info("结束上传<=============");
        return "/" +newFileName;
    };

    /**
     * 将原先的文件名替换为时间序列
     * @param fileType
     * @return
     */
    private String getNewFileName(String fileType){
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
}
