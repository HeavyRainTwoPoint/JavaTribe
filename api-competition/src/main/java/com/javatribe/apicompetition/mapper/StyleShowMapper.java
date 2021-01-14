package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.StyleShow;
import java.util.List;

public interface StyleShowMapper {
    int deleteByPrimaryKey(Long showId);

    int insert(StyleShow record);

    StyleShow selectByPrimaryKey(Long showId);

    List<StyleShow> selectAll();

    int updateByPrimaryKey(StyleShow record);
}