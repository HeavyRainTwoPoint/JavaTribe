package com.javatribe.apishare.controller.admin;

import com.javatribe.apicommon.config.properties.AliOssProperties;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.service.ArticleService;
import com.javatribe.apishare.vo.ArticleAndTags;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/17 20:35
 */

@RestController
@RequestMapping("/share/admin")
public class AdminArticleController {
    @Autowired
    private ArticleService articleService;


//    @Autowired
//    private OSS oss;

    @PutMapping("/add")
    public Result add(@RequestBody ArticleAndTags articleAndTags) {

        return null;
    }

    @PostMapping("/update")
    public Result update(@RequestBody Article article) {

        return null;
    }

    @PostMapping("delete")
    public Result delete(@RequestBody String artNo) {

        return null;
    }

    @GetMapping("/oss")
    public Result oss(AliOssProperties aliOssProperties) {
//        LoggerFactory.getLogger(this.getClass()).info("oss:{}", oss);
//        LoggerFactory.getLogger(this.getClass()).info(oss == null ? "空" : "非空");
//        return Result.success();
        LoggerFactory.getLogger(this.getClass()).info("aliyunProperties:{}", aliOssProperties);
        LoggerFactory.getLogger(this.getClass()).info(aliOssProperties == null ? "空" : "非空");
        return Result.success();

    }

}
