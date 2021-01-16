package com.javatribe.apicompetition.service;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/16 15:16
 */
public interface CompetitionIntroductionService {

    /**
     * 因为也就那几个比赛，就不分页了
     * 首页 比赛展示
     * @return
     */
    List<CompetitionIntroduction> firstPageShow();

    /**
     * 管理员插入一条数据
     * @param dbRowInfo
     */
    void insertCompetitionInfo(CompetitionIntroduction dbRowInfo);

    /**
     * 逻辑删除
     */
    void deleteCompetitionInfoById(Long competitionId);

    /**
     * 更新 数据库信息
     * @param competitionIntroduction
     */
    void updateCompetitionInfo(CompetitionIntroduction competitionIntroduction);
}
