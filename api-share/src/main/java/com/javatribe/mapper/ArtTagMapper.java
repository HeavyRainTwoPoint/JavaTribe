package com.javatribe.mapper;

import com.javatribe.vo.TagsRelationship;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArtTagMapper {
    int insertTags(TagsRelationship tags);
}