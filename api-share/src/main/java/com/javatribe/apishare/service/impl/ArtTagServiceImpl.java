package com.javatribe.apishare.service.impl;

import com.javatribe.apishare.mapper.ArtTagMapper;
import com.javatribe.apishare.service.ArtTagService;
import com.javatribe.apishare.vo.TagsRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/14 21:06
 */
@Service
public class ArtTagServiceImpl implements ArtTagService {
    @Autowired(required = false)
    private ArtTagMapper artTagMapper;
    /**
     * 将文章与其标签的关系记录下来
     * @param tags 属于该文章的标签集
     * @return
     */
    @Override
    public int insertTags(TagsRelationship tags) {
        return artTagMapper.insertTags(tags);
    }

    /**
     * 确认给定id下是否有已经发布的文章
     * @param tagId 待确认tagId
     * @return
     */
    @Override
    public int checkTag(int tagId) {
        return artTagMapper.checkTag(tagId);
    }
}
