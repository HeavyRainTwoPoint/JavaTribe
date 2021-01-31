package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapper;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/16 15:17
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
// @CacheConfig(cacheNames = "competition_introduction")
public class CompetitionIntroductionServiceImpl implements CompetitionIntroductionService {

    final CompetitionIntroductionMapper competitionIntroductionMapper;
    final CompetitionIntroductionMapperCustom competitionIntroductionMapperCustom;

    /**
     * 因为也就那几个比赛，就不分页了
     * 首页 比赛展示
     *
     * @return
     */
    @Override
    // @Cacheable(key = "'first_page_competition'")
    public List<CompetitionIntroduction> firstPageShow() {
        return competitionIntroductionMapper.selectAll();
    }

    /**
     * 管理员插入一条数据
     *
     * @param dbRowInfo
     */
    @Override
    public void insertCompetitionInfo(CompetitionIntroduction dbRowInfo) {
        competitionIntroductionMapper.insert(
                dbRowInfo.withGmtCreate(new Date()).withGmtModified(new Date())
                .withDeleteStatus(false)
        );
    }

    /**
     * 逻辑删除
     *
     * @param competitionId
     */
    @Override
    public void deleteCompetitionInfoById(Long competitionId) {
        competitionIntroductionMapperCustom.updateSelective(new CompetitionIntroduction().withDeleteStatus(true).withCompetitionId(competitionId).withGmtModified(new Date()));
    }

    /**
     * 更新 数据库信息
     *
     * @param competitionIntroduction
     */
    @Override
    public void updateCompetitionInfo(CompetitionIntroduction competitionIntroduction) {
        competitionIntroductionMapperCustom.updateSelective(competitionIntroduction.withGmtModified(new Date()));
    }
}
