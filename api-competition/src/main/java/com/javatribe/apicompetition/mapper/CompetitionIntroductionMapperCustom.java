package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/16 15:24
 */
public interface CompetitionIntroductionMapperCustom {

    void updateSelective(CompetitionIntroduction row);

    List<CompetitionIntroduction> selectFirstPageShow();
}
