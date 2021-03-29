package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.pojo.vo.YearAndCompetitionVO;
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


    /**
     * 列出比赛 和 年份信息
     * @return
     */
    List<CompetitionAndYearsVO> listAllCompetitionAndYears();


    /**
     * 和上面一样的。
     * 前端懒
     * @return 和
     */
    List<YearAndCompetitionVO> listAllCompetitionAndYears2();

    // List<Integer> getAllYearNumbers(@Param("competitionId") Integer competitionId);
}
