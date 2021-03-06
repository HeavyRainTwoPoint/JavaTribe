package com.javatribe.apicompetition.service.impl;

import com.github.pagehelper.PageHelper;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapper;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.pojo.dto.YearAndStyleShowVO;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
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
     * ?????????????????????????????????????????????
     * ?????? ????????????
     *
     * @return
     */
    @Override
    // @Cacheable(key = "'first_page_competition'")
    public List<CompetitionIntroduction> firstPageShow() {
        return competitionIntroductionMapperCustom.selectFirstPageShow();
    }

    /**
     * ???????????????????????????
     *
     * @param dbRowInfo
     */
    @Override
    public void insertCompetitionInfo(CompetitionIntroduction dbRowInfo) {
        //???????????????????????????
        InsertUtil.setDefaultValue(dbRowInfo);
        competitionIntroductionMapper.insert(
                dbRowInfo.withGmtCreate(new Date()).withGmtModified(new Date())
                .withDeleteStatus(false)
        );
    }

    /**
     * ????????????
     *
     * @param competitionId
     */
    @Override
    public void deleteCompetitionInfoById(Long competitionId) {
        competitionIntroductionMapperCustom.updateSelective(new CompetitionIntroduction().withDeleteStatus(true).withCompetitionId(competitionId).withGmtModified(new Date()));
    }

    /**
     * ?????? ???????????????
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
    //         result.setMessage("????????????????????????????????????");
    //         return result;
    //     }
    //     //?????????????????????????????????
    //     String competitionName = competition.getCompetitionName();
    //     int i = competitionIntroductionMapper.selectByCompetitionName(competitionName);
    //     if (i>0){
    //         result.setCode(401);
    //         result.setMessage("?????????????????????????????????");
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
    //         result.setMessage("????????????");
    //         return result;
    //     }
    // }


    /**
     * ????????? ?????????  markdwon ???????????????
     * @return
     */
    @Override
    public CompetitionIntroduction getCompetitionDetailWithRawData(Integer competitionId) {
        return competitionIntroductionMapperCustom.getDetailInfoById(competitionId);
    }

    /**
     * ??????????????????????????????????????? markdown ??? HTML ????????????
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
     * ?????? ???????????????????????????
     * @return
     */
    @Override

    public List<CompetitionAndYearsVO> listCompetitionAndYearsVo() {
        //???????????????


        List<CompetitionAndYearsVO> res = competitionIntroductionMapperCustom.listAllCompetitionAndYears();
        if (res==null || res.isEmpty()) return Collections.emptyList();
        for (CompetitionAndYearsVO x: res) {
            if (x.getYears()!=null) {
                List<CompetitionYear> list = x.getYears();
                if (list!=null && list.size()==1) {
                    if (list.get(0).getTheYear()==null) {
                        //????????????????????? mybatis ??????????????????????????????????????????
                        x.setYears(Collections.emptyList());
                    }
                }
            }
        }
        return  res;
    }
    @Transactional(readOnly = true)
    @Override
    public List<YearAndCompetitionVO> listYearAndCompetitionVO() {

        List<YearAndCompetitionVO> resultList = competitionIntroductionMapperCustom.listAllCompetitionAndYears2();
        if (resultList==null|| resultList.isEmpty()) {
            //??????
            return Collections.emptyList();
        }

        for (YearAndCompetitionVO yearAndCompetitionVO: resultList) {
            final List<YearAndStyleShowVO> yearList = yearAndCompetitionVO.getYearList();
            Long competitionId = yearAndCompetitionVO.getCompetitionId();
            //?????? mybatis ????????? null ???
            if (yearList.size()==1) {
                if (yearList.get(0).getYearId()==null) {
                    //id ???null ??????????????? ?????????
                    yearAndCompetitionVO.setYearList(Collections.emptyList());
                }
            }
            if (yearList!=null  && yearList.size()>0 && competitionId!=null) {
                for (YearAndStyleShowVO yearAndStyle: yearList) {
                    if (yearAndStyle.getYearId()!=null) {
                        Result<List<StyleShowVO>> styleList = tribeStyleShowService.getAllStyleShowVOByCompetitionIdAndTheYear(yearAndStyle.getYearId(),competitionId.intValue());
                        if (styleList!=null) {
                            yearAndStyle.setStyleShowList(styleList.getData());
                        }
                    }
                }
            }
        }


        return resultList;
    }


    // /**
    //  * ?????? ??? ?????? ID????????????????????? ????????????
    //  * @param competitionId
    //  * @return
    //  */
    // public List<Integer> getAllYearNumber(Integer competitionId) {
    //     return null;
    // }


}
