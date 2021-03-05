package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapper;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import com.javatribe.apicompetition.util.InsertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        return competitionIntroductionMapperCustom.selectFirstPageShow();
    }

    /**
     * 管理员插入一条数据
     *
     * @param dbRowInfo
     */
    @Override
    public void insertCompetitionInfo(CompetitionIntroduction dbRowInfo) {
        //设置数据插入默认值
        InsertUtil.setDefaultValue(dbRowInfo);
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
        competitionIntroductionMapperCustom.updateSelective(
                competitionIntroduction.withGmtModified(new Date()));
    }

    @Override
    public Result addCompetition(CompetitionIntroduction competition) {
        Result result = new Result();
        if (Objects.isNull(competition.getCompetitionName())){
            result.setCode(401);
            result.setMessage("比赛名字为空，请重新填写");
            return result;
        }
        //判断是否有相同比赛名字
        String competitionName = competition.getCompetitionName();
        int i = competitionIntroductionMapper.selectByCompetitionName(competitionName);
        if (i>0){
            result.setCode(401);
            result.setMessage("添加出错，比赛名字重复");
            return result;
        }
        competition.setDeleteStatus(false);
        competition.setSignUp(1);
        competition.setGmtCreate(new Date());
        int insertRow = competitionIntroductionMapper.insert(competition);
        if (insertRow>0){
            return Result.success();
        }else{
            result.setCode(401);
            result.setMessage("插入失败");
            return result;
        }
    }
}
