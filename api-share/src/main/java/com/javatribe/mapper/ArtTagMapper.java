package com.javatribe.mapper;

import com.javatribe.vo.TagsRelationship;
import org.apache.ibatis.annotations.Mapper;

public interface ArtTagMapper {
    int insertTags(TagsRelationship tags);
}