package com.javatribe.apicompetition.controller;

import com.aliyun.oss.OSS;
import com.javatribe.apicommon.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author lyr
 * @create 2020/11/21 21:53
 */
@RestController
public class TestController {

    @Resource
    private OSS oss;


    @GetMapping("/h")
    public Result ok() {
        return Result.success();
    }

    @PostMapping("/file")
    public Result okkk(@RequestPart MultipartFile file) throws IOException {
        oss.putObject("javatribe","xxx.xxx",file.getInputStream());
        return Result.success();
    }

}
