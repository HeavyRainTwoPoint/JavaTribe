package com.javatribe.apienroll.manager;
import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import com.javatribe.apicommon.config.properties.AliOssProperties;
import com.javatribe.apicommon.core.constant.OSSBucketName;
import com.javatribe.apicommon.core.constant.OSSHost;
import com.javatribe.apicommon.core.constant.enums.FileType;
import com.javatribe.apicommon.dto.FileUploadDTO;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 15:51
 * @description 文件管理
 */
@Component
public class FileCommandManager {
    private static final Logger logger = LoggerFactory.getLogger(FileCommandManager.class);


    @Resource
    AliOssProperties aliOssProperties;

    @Resource
    HttpServletResponse httpServletResponse;

    @Autowired
    private OSS oss;

    // 文件上传
    public Response<FileUploadDTO> upload(MultipartFile file, FileType fileType) {
        FileUploadDTO dto = new FileUploadDTO();
        if (fileType.getType() == FileType.IMAGE.getType()) {
            if (beginUpload(file, dto, FileType.IMAGE)) return new Response<>(dto);
        } else if (fileType.getType() == FileType.ZIP.getType()) {
            if (beginUpload(file, dto, FileType.ZIP)) return new Response<>(dto);
        }
        // 上传失败
        return new Response<>(dto);
    }

    private boolean beginUpload(MultipartFile file, FileUploadDTO dto, FileType fileType) {
        try {

            if (oss.doesBucketExist(OSSBucketName.JAVA_TRIBE)) {
                logger.info("the bucket " + OSSBucketName.JAVA_TRIBE + "is already exist.");
            } else {
                logger.info("create bucket name " + OSSBucketName.JAVA_TRIBE);
                oss.createBucket(OSSBucketName.JAVA_TRIBE);
            }
            String fileName = getNewFileName(fileType.getTypeName(),file);
            // 要上传到的oss地址
            String fileUri = OSSHost.JAVA_TRIBE
                    + "/" + fileName;
            // 上传
            oss.putObject(OSSBucketName.JAVA_TRIBE, fileName,new ByteArrayInputStream(file.getBytes()));
            dto.setUploadDate(new Date());
            dto.setUrl(fileUri);
            dto.setFileTypeName(FileType.ZIP.getTypeName());
            dto.setFileName(file.getOriginalFilename());
            dto.setSuccess(true);
            dto.setContentType(file.getContentType());
            return true;
        } catch (Exception e) {
            logger.info("upload file fail -> {}", file.getOriginalFilename());
            e.printStackTrace();
        } finally {
//            oss.shutdown();
        }
        return false;
    }

    public Response<Boolean> download(FileManager fileManager) throws IOException {
        if (ObjectUtil.isNull(fileManager)) {
            logger.info("不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        OSS oss = aliOssProperties.getOSSClient();
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = oss.getObject(OSSBucketName.JAVA_TRIBE, fileManager.getFileUrl());

        // 读取文件内容。
        logger.info("begin to reaad the file...");
        httpServletResponse.setContentType(fileManager.getContenType());
        //设置文件头：最后一个参数是设置下载文件名
        httpServletResponse.setHeader("Content-Disposition", "attachment;fileName="+fileManager.getFileName());

        InputStream in = ossObject.getObjectContent();
        OutputStream out = httpServletResponse.getOutputStream();

        int len;
        byte[] buffer = new byte[1024 * 10];
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        out.flush();

        // 关闭OSSClient。
        oss.shutdown();

        return new Response<>(true);

    }


    /**
     * 将原先的文件名替换为时间序列
     * @param fileType
     * @param file
     * @return
     */
    private static String getNewFileName(String fileType, MultipartFile file){
        DateTime dateTime = new DateTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fileType + "/");
        stringBuilder.append(dateTime.toString("yyyyMMddHHmmss"));
        stringBuilder.append(getMillTime(dateTime));
        stringBuilder.append("_" + file.getOriginalFilename());
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
