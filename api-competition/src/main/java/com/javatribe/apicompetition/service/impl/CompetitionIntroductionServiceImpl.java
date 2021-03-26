package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapper;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.pojo.dto.YearAndStyleShowVO;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;
import com.javatribe.apicompetition.pojo.vo.YearAndCompetitionVO;
import com.javatribe.apicompetition.service.CompetitionIntroductionService;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import com.javatribe.apicompetition.util.InsertUtil;
import com.javatribe.apicompetition.util.MarkdownUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private CompetitionIntroductionService competitionIntroductionService;
    final TribeStyleShowService tribeStyleShowService;

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
        insertCompetitionInfo(competition);
        return Result.success();
    }

    // @Override
    // public Result addCompetition(CompetitionIntroduction competition) {
    //     Result result = new Result();
    //     if (Objects.isNull(competition.getCompetitionName())){
    //         result.setCode(401);
    //         result.setMessage("比赛名字为空，请重新填写");
    //         return result;
    //     }
    //     //判断是否有相同比赛名字
    //     String competitionName = competition.getCompetitionName();
    //     int i = competitionIntroductionMapper.selectByCompetitionName(competitionName);
    //     if (i>0){
    //         result.setCode(401);
    //         result.setMessage("添加出错，比赛名字重复");
    //         return result;
    //     }
    //     competition.setDeleteStatus(false);
    //     competition.setSignUp(1);
    //     competition.setGmtCreate(new Date());
    //     int insertRow = competitionIntroductionMapper.insert(competition);
    //     if (insertRow>0){
    //         return Result.success();
    //     }else{
    //         result.setCode(401);
    //         result.setMessage("插入失败");
    //         return result;
    //     }
    // }


    /**
     * 管理员 编辑的  markdwon 格式的比赛
     * @return
     */
    @Override
    public CompetitionIntroduction getCompetitionDetailWithRawData(Integer competitionId) {
        return competitionIntroductionMapperCustom.getDetailInfoById(competitionId);
    }

    /**
     * 前端需要富文本展示，后台将 markdown 转 HTML 方便展示
     * @param competitionId
     * @return
     */
    @Override
    public CompetitionIntroduction getCompetitionDetailInfoWithHtml(Integer competitionId) {
         CompetitionIntroduction x = competitionIntroductionMapperCustom.getDetailInfoById(competitionId);
         if (x==null) {
             return  x;
         }
         String html = MarkdownUtils.markdownToHtml(x.getShowContent());
         x.setShowContent(html);
         return x;
    }


    /**
     * 获取 风采展示和比赛队伍
     * @return
     */
    @Override

    public List<CompetitionAndYearsVO> listCompetitionAndYearsVo() {
        return competitionIntroductionMapperCustom.listAllCompetitionAndYears();
    }
    @Transactional(readOnly = true)
    @Override
    public List<YearAndCompetitionVO> listYearAndCompetitionVO() {
        List<YearAndCompetitionVO> resultList = competitionIntroductionMapperCustom.listAllCompetitionAndYears2();
        if (resultList==null|| resultList.isEmpty()) {
            //判空
            return Collections.emptyList();
        }

        for (YearAndCompetitionVO yearAndCompetitionVO: resultList) {
            final List<YearAndStyleShowVO> yearList = yearAndCompetitionVO.getYearList();
            Long competitionId = yearAndCompetitionVO.getCompetitionId();
            if (yearList!=null  && yearList.size()>0 && competitionId!=null) {
                for (YearAndStyleShowVO yearAndStyle: yearList) {
                    Result<List<StyleShowVO>> styleList = tribeStyleShowService.getAllStyleShowVOByCompetitionIdAndTheYear(yearAndStyle.getYearId(),competitionId.intValue());
                    if (styleList!=null) {
                        yearAndStyle.setStyleShowList(styleList.getData());
                    }
                }
            }
        }


        return resultList;
    }


    // /**
    //  * 前端 传 比赛 ID，后端查出比赛 有第几届
    //  * @param competitionId
    //  * @return
    //  */
    // public List<Integer> getAllYearNumber(Integer competitionId) {
    //     return null;
    // }


}
