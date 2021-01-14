package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import java.util.List;

public interface CompetitionIntroductionMapper {
    int deleteByPrimaryKey(Long competitionId);

    int insert(CompetitionIntroduction record);

    CompetitionIntroduction selectByPrimaryKey(Long competitionId);

    List<CompetitionIntroduction> selectAll();

    int updateByPrimaryKey(CompetitionIntroduction record);
}