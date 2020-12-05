package com.javatribe.controller;

import com.javatribe.mapper.ArtTagMapper;
import com.javatribe.vo.TagsRelationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 15:12
 */

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private ArtTagMapper artTagMapper;

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
}
