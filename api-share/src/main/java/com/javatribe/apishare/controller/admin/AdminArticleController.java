package com.javatribe.apishare.controller.admin;

import com.aliyun.oss.OSS;
import com.javatribe.apicommon.config.properties.AliOssProperties;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.protocol.UploadStatus;
import com.javatribe.apishare.service.ArticleService;
import com.javatribe.apishare.utils.AliyunOssUtil;
import com.javatribe.apishare.vo.ArticleAndTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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

    private final String OK = "ok";


    @Autowired
    private OSS oss;
    @Autowired
    private AliOssProperties properties;

    /**
     * 添加文章
     * @param articleAndTags
     * @return
     */
    @PutMapping("/add")
    public Result add(@RequestBody ArticleAndTags articleAndTags) {
        Article article = articleAndTags.getArticle();
        String valid = isValid(article);
        if (!OK.equals(valid)) {
            return Result.fail(valid);
        }
        if (articleAndTags == null || articleAndTags.getTags().size() <= 0) {
            return  Result.fail("未选择标签！");
        }
        int result = articleService.insertArticle(articleAndTags);
        return result == 1 ? Result.success() : Result.fail("发生内部错误，文章上传失败！请重试！");
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Article article) {
        String valid = isValid(article);
        if (!OK.equals(valid)) {
            return Result.fail(valid);
        }
        if (article.getArtNo() == null || "".equals(article.getArtNo())) {
            return Result.fail("缺少关键参数：artNo");
        }
        int result = articleService.updateArtByNo(article);
        return result == 1 ? Result.success() : Result.fail("找不到符合条件的文章！请检查后重试！");
    }

    /**
     * 删除文章
     * @param map 提供 artNo 参数
     * @return
     */
    @PostMapping("delete")
    public Result delete(@RequestBody Map<String, String> map) {
        String artNo = map.get("artNo");
        if (artNo == null || "".equals(artNo.trim())) {
            return Result.fail("参数不能为空！");
        }
        int result = articleService.deleteOneByArtNo(artNo);
        return result == 1 ? Result.success() : Result.fail("删除失败！");
    }

    /**
     * 上传图片接口 只能上传一张
     * @param multipartFile
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("image")MultipartFile multipartFile) {
        if (multipartFile == null) {
            return new Result(UploadStatus.FILE_ISNULL.getCode(), UploadStatus.FILE_ISNULL.getMessage(), null);
        }
        UploadStatus uploadStatus = AliyunOssUtil.uploadImage(oss, multipartFile, properties.getBucketName());
        String message = uploadStatus.getCode() == 200 ? properties.getHost() + uploadStatus.getMessage() : uploadStatus.getMessage();
        return new Result(uploadStatus.getCode(), message, null);
    }

    /**
     * 上传图片，为什么重复呢？因为element-ui的问题
     * @param multipartFile 文件
     * @return
     */
    @PostMapping("/uploadImg")
    public Result uploadImg(@RequestParam("file") MultipartFile multipartFile){
        if (multipartFile == null) {
            return new Result(UploadStatus.FILE_ISNULL.getCode(), UploadStatus.FILE_ISNULL.getMessage(), null);
        }
        UploadStatus uploadStatus = AliyunOssUtil.uploadImage(oss, multipartFile, properties.getBucketName());
        String message = uploadStatus.getCode() == 200 ? properties.getHost() + uploadStatus.getMessage() : uploadStatus.getMessage();
        return new Result(uploadStatus.getCode(), message, null);
    }

    /**
     * 验证article是否满足条件
     * @param article
     * @return
     */
    private String isValid(Article article) {
        if (article == null) {
            return "非法请求";
        }
        if (article.getArtTitle() == null || "".equals(article.getArtTitle().trim())) {
            return "标题不能为空！";
        }
        if (article.getArtSummary() == null || "".equals(article.getArtSummary().trim())) {
            return "摘要不能为空！";
        }
        if (article.getArtContent() == null || "".equals(article.getArtContent().trim())) {
            return "正文内容不能为空！";
        }
        return OK;
    }

}
