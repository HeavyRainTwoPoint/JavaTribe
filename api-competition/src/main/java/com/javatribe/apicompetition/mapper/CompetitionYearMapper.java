package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.pojo.po.CompetitionYearExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CompetitionYearMapper {
    long countByExample(CompetitionYearExample example);

    int deleteByExample(CompetitionYearExample example);

    int deleteByPrimaryKey(Integer yearId);

    int insert(CompetitionYear record);

    int insertSelective(CompetitionYear record);

    List<CompetitionYear> selectByExampleWithRowbounds(CompetitionYearExample example, RowBounds rowBounds);

    List<CompetitionYear> selectByExample(CompetitionYearExample example);

    CompetitionYear selectByPrimaryKey(Integer yearId);

    int updateByExampleSelective(@Param("record") CompetitionYear record, @Param("example") CompetitionYearExample example);

    int updateByExample(@Param("record") CompetitionYear record, @Param("example") CompetitionYearExample example);

    int updateByPrimaryKeySelective(CompetitionYear record);

    int updateByPrimaryKey(CompetitionYear record);
}