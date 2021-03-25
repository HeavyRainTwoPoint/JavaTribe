package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CompetitionIntroductionMapper {
    long countByExample(CompetitionIntroductionExample example);

    int deleteByExample(CompetitionIntroductionExample example);

    int deleteByPrimaryKey(Long competitionId);

    int insert(CompetitionIntroduction record);

    int insertSelective(CompetitionIntroduction record);

    List<CompetitionIntroduction> selectByExampleWithRowbounds(CompetitionIntroductionExample example, RowBounds rowBounds);

    List<CompetitionIntroduction> selectByExample(CompetitionIntroductionExample example);

    CompetitionIntroduction selectByPrimaryKey(Long competitionId);

    int updateByExampleSelective(@Param("record") CompetitionIntroduction record, @Param("example") CompetitionIntroductionExample example);

    int updateByExample(@Param("record") CompetitionIntroduction record, @Param("example") CompetitionIntroductionExample example);

    int updateByPrimaryKeySelective(CompetitionIntroduction record);

    int updateByPrimaryKey(CompetitionIntroduction record);
}