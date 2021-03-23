package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/16 15:24
 */
public interface CompetitionIntroductionMapperCustom {

    void updateSelective(CompetitionIntroduction row);

    List<CompetitionIntroduction> selectFirstPageShow();

    /**
     * 获取比赛的详细信息
     * @param competitionId
     * @return
     */
    CompetitionIntroduction getDetailInfoById(@Param("competitionId") Integer competitionId);

    // List<Integer> getAllYearNumbers(@Param("competitionId") Integer competitionId);
}
