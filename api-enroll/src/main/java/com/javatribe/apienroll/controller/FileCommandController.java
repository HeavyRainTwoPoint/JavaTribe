package com.javatribe.apienroll.controller;

import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.core.constant.enums.FileType;
import com.javatribe.apicommon.dto.FileUploadDTO;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.dao.FileManagerMapper;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.entity.FileManagerQTO;
import com.javatribe.apienroll.manager.FileCommandManager;
import com.javatribe.apienroll.service.admin.EnrollTestAdminService;
import com.javatribe.apienroll.service.common.FileManagerCommonService;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 17:02
 * @description 文件操作
 */
@RestController
@RequestMapping("/javatribe/enroll/common/file_command")
public class FileCommandController {
    private static final Logger logger = LoggerFactory.getLogger(FileCommandController.class);

    @Resource
    private FileCommandManager fileCommandManager;

    @Resource
    private FileManagerMapper fileManagerMapper;

    @Resource
    private FileManagerCommonService fileManagerCommonService;

    @Resource
    private EnrollTestAdminService enrollTestAdminService;

    /**
     * 上传考核作业
     * @param multipartFile 文件
     * @param ownerName 上传者
     * @param directionCode 方向代号
     * @return
     */
    @Transactional
    @TokenFreeAnnotation
    @PostMapping("/upload/enroll_test")
    public Response<FileUploadDTO> uploadEnrollTestFile(@RequestPart("file") MultipartFile multipartFile,
                                                  @RequestParam("owner_name") String ownerName, @RequestParam("direction_code") Integer directionCode) {
        if (ObjectUtil.isNull(multipartFile,ownerName)) {
            logger.info("参数不合法");
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        FileUploadDTO dto = fileCommandManager.upload(multipartFile, FileType.ZIP).getData();

        // 上传成功
        if (dto.isSuccess()) {
            FileManager fileManager = new FileManager();
            fileManager.setFileName(dto.getFileName());
            fileManager.setUploader(ownerName);
            fileManager.setFileUrl(dto.getUrl());
            fileManager.setContenType(dto.getContentType());
            fileManager.setFileType(FileType.ZIP.getType());
            fileManagerCommonService.add(fileManager);

            EnrollTest test = new EnrollTest();
            test.setTestName(multipartFile.getOriginalFilename());
            test.setFileUrl(dto.getUrl());
            test.setOwnnerName(ownerName);
            test.setDirectionCode(directionCode);
            enrollTestAdminService.add(test);

            return new Response<>(dto);
        }
        return Response.fail(ResponseStatus.OSS_ERROR);
    }

    @GetMapping("/download_file")
    @TokenFreeAnnotation
    @Transactional
    public Response download(@RequestParam("fileUrl") String fileUrl) {
        if (ObjectUtil.isNull(fileUrl) || ObjectUtil.isNull(fileUrl)) {
            logger.info("参数不合法->{}",fileUrl);
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        Boolean download;
        try {
            FileManager fileManager = new FileManager();
            fileManager.setFileUrl(fileUrl);
            download = fileCommandManager.download(fileManager).getData();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(ResponseStatus.FILE_DOWNLOAD_ERROR);
        }
        try {
            if (download) {
                FileManagerQTO qto = new FileManagerQTO();
                qto.createCriteria().andDeleteMarkEqualTo(0).andFileUrlEqualTo(fileUrl);
                List<FileManager> fileManagers = fileManagerMapper.selectByExample(qto);
                if (!fileManagers.isEmpty()) {
                    // 执行下载数量+1
                    fileManagers.get(0).setDownloadCount(fileManagers.get(0).getDownloadCount() + 1);
                }

                return fileManagerCommonService.update(fileManagers.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.fail(ResponseStatus.FILE_DOWNLOAD_ERROR);
    }

    @Transactional
    @TokenFreeAnnotation
    @PostMapping("/upload/file")
    public Response<FileUploadDTO> uploadFile(@RequestPart("file") MultipartFile multipartFile,
                                                        @RequestParam("uploader") String ownerName) {
        FileUploadDTO dto = fileCommandManager.upload(multipartFile, FileType.ZIP).getData();

        // 上传成功
        if (dto.isSuccess()) {
            FileManager fileManager = new FileManager();
            fileManager.setFileName(dto.getFileName());
            fileManager.setFileUrl(dto.getUrl());
            fileManager.setUploader(ownerName);
            fileManager.setContenType(dto.getContentType());
            fileManager.setFileType(FileType.ZIP.getType());
            fileManagerCommonService.add(fileManager);
            return Response.success(dto);
        }

        return Response.fail(null);

    }

    @Transactional
    @TokenFreeAnnotation
    @PostMapping("/upload")
    public Response<FileUploadDTO> uploadFile(@RequestPart("file") MultipartFile multipartFile) {
        FileUploadDTO dto = fileCommandManager.upload(multipartFile, FileType.ZIP).getData();


        // 上传成功
        if (dto.isSuccess()) {
            FileManager fileManager = new FileManager();
            fileManager.setFileName(dto.getFileName());
            fileManager.setFileUrl(dto.getUrl());
            fileManager.setUploader("default");
            fileManager.setContenType(dto.getContentType());
            fileManager.setFileType(FileType.ZIP.getType());
            fileManagerCommonService.add(fileManager);
            return Response.success(dto);
        }

        return Response.fail(null);

    }





}
