package com.javatribe.apienroll.controller;

import com.javatribe.apicommon.core.constant.enums.FileType;
import com.javatribe.apicommon.dto.FileDownloadDTO;
import com.javatribe.apicommon.dto.FileUploadDTO;
import com.javatribe.apicommon.dto.Response;
import com.javatribe.apicommon.dto.ResponseStatus;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.manager.FileCommandManager;
import com.javatribe.apienroll.service.EnrollTestAdminService;
import com.javatribe.apienroll.service.FileManagerCommonService;
import com.javatribe.apienroll.service.impl.EnrollDirectionAdminServiceImpl;
import com.javatribe.apienroll.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    private FileManagerCommonService fileManagerCommonService;

    @Resource
    private EnrollTestAdminService enrollTestAdminService;

    @Transactional
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
            fileManager.setFileUrl(dto.getUri());
            fileManager.setContenType(dto.getContentType());
            fileManager.setFileType(FileType.ZIP.getType());
            fileManagerCommonService.add(fileManager);

            EnrollTest test = new EnrollTest();
            test.setTestName(multipartFile.getOriginalFilename());
            test.setFileUrl(dto.getUri());
            test.setOwnnerName(ownerName);
            test.setDirectionCode(directionCode);
            enrollTestAdminService.add(test);

            return new Response<>(dto);
        }
        return Response.fail(ResponseStatus.PARAMS_ERROR);
    }

    @GetMapping("/download_file")
    @Transactional
    public Response download(FileManager fileManager) {
        if (ObjectUtil.isNull(fileManager)) {
            logger.info("参数不合法->{}",fileManager);
            return Response.fail(ResponseStatus.PARAMS_ERROR);
        }
        Boolean download;
        try {
            download = fileCommandManager.download(fileManager).getData();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.fail(ResponseStatus.FILE_DOWNLOAD_ERROR);
        }
        if (download) {
            // 执行下载数量+1
            fileManager.setDownloadCount(fileManager.getDownloadCount() + 1);
            return fileManagerCommonService.update(fileManager);
        }
        return Response.fail(ResponseStatus.FILE_DOWNLOAD_ERROR);
    }
}
