package com.javatribe.mapper;

import com.javatribe.po.Tag;
import org.apache.ibatis.annotations.Mapper;

public interface TagMapper {
    /**
     * 插入一个新的标签
     * @param tag 标签实体
     * @return 返回是否插入成功的结果，1表示成功，0表示失败
     */
    int insertTag(Tag tag);
}