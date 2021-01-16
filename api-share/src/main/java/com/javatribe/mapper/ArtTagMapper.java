package com.javatribe.mapper;

import com.javatribe.vo.TagsRelationship;

public interface ArtTagMapper {
    /**
     * 将文章与其标签的关系记录下来
     * @param tags 属于该文章的标签集
     * @return
     */
    int insertTags(TagsRelationship tags);

    /**
     * 确认给定id下是否有已经发布的文章
     * @param tagId 待确认tagId
     * @return
     */
    int checkTag(int tagId);

}