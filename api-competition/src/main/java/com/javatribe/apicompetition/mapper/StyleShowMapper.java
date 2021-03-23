package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.po.StyleShowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StyleShowMapper {
    long countByExample(StyleShowExample example);

    int deleteByExample(StyleShowExample example);

    int deleteByPrimaryKey(Long showId);

    int insert(StyleShow record);

    int insertSelective(StyleShow record);

    List<StyleShow> selectByExampleWithRowbounds(StyleShowExample example, RowBounds rowBounds);

    List<StyleShow> selectByExample(StyleShowExample example);

    StyleShow selectByPrimaryKey(Long showId);

    int updateByExampleSelective(@Param("record") StyleShow record, @Param("example") StyleShowExample example);

    int updateByExample(@Param("record") StyleShow record, @Param("example") StyleShowExample example);

    int updateByPrimaryKeySelective(StyleShow record);

    int updateByPrimaryKey(StyleShow record);
}