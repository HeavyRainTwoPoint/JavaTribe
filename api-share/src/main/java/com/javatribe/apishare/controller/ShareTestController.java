package com.javatribe.apishare.controller;

import com.javatribe.apishare.mapper.ArtTagMapper;
import com.javatribe.apishare.mapper.ArticleMapper;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.service.ArticleService;
import com.javatribe.apishare.vo.TagsRelationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 15:12
 */

@RestController
@RequestMapping("/share")
public class ShareTestController {
    private static final Logger logger = LoggerFactory.getLogger(ShareTestController.class);
    @Autowired
    private ArtTagMapper artTagMapper;
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/test")
    public String test() {
        TagsRelationship tags = new TagsRelationship();
        tags.setArtId(1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        tags.setTagIds(list);
        logger.info("插入结果：" + artTagMapper.insertTags(tags));
        return "1";
    }

    @GetMapping("/get")
    public Article get(@PathParam("artNo") String artNo) {
        return articleService.selectOneByNo(artNo);
    }

    @GetMapping("/del")
    public String del(@PathParam("artNo") String artNo) {
        logger.info("测试：" + articleService == null ? "null": "no");
        int result = articleService.deleteOneByArtNo(artNo);
        return result == 1 ? "删除成功！！！" : "删除失败！！！";
    }

}
