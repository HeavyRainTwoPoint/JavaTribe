package com.javatribe.controller;

import com.javatribe.mapper.ArtTagMapper;
import com.javatribe.mapper.ArticleMapper;
import com.javatribe.pojo.Article;
import com.javatribe.vo.TagsRelationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//        logger.info("插入结果：" + artTagMapper.insertTags(tags));
        return "1";
    }

    @GetMapping("/get")
    public Article get(@PathParam("id") int id) {
        return articleMapper.selectOneById(id);
    }

    @GetMapping("/del")
    public String del(@PathParam("id") int id) {
        logger.info("测试：" + articleMapper == null ? "null": "no");
        int result = articleMapper.deleteOneById(id);
        return result == 1 ? "删除成功！！！" : "删除失败！！！";
    }
}
