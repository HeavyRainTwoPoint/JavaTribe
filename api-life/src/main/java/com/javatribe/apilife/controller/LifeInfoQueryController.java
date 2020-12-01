package com.javatribe.apilife.controller;

import com.javatribe.apilife.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifeInfoQueryController {

    @GetMapping("/ee")
    public Result okkkk() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }
}
