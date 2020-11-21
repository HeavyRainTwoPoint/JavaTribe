package com.javatribe.apicompetition.controller;

import com.javatribe.apicommon.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyr
 * @create 2020/11/21 21:53
 */
@RestController
public class TestController {

    @GetMapping("/h")
    public Result ok() {
        return Result.success();
    }
}
