package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicommon.exception.BusinessException;
import com.javatribe.apicommon.exception.ServiceException;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.mapper.CompetitionYearMapper;
import com.javatribe.apicompetition.mapper.StyleShowMapper;
import com.javatribe.apicompetition.mapper.StyleShowMapperCustom;
import com.javatribe.apicompetition.pojo.po.*;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.pojo.vo.FrontStyleShowVO;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import com.javatribe.apicompetition.util.InsertUtil;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 部落风采模块
 * @Author lyr
 * @create 2021/1/16 15:49
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TribeStyleShowServiceImpl implements TribeStyleShowService {
    final StyleShowMapper styleShowMapper;
    final StyleShowMapperCustom styleShowMapperCustom;
    // final Numberof
    final CompetitionYearMapper competitionYearMapper;

    final CompetitionIntroductionMapperCustom competitionIntroductionMapperCustom;

    /**
     * 部落官网前端 获取风采展示
     *
     * @return
     */
    @Override
    public List<FrontStyleShowVO> getAllStyleShowFronted() {
        return styleShowMapperCustom.getFrontStyleShowVO();
    }

    /**
     * @return 获取风采暂时
     */
    @Override
    public List<StyleShowVO> getAllStyleShow() {
        return styleShowMapperCustom.getFirstPage()
                ;

    }


    /**
     * 更新风采展示
     *
     * @param styleShow
     * @return
     */
    @Override
    public int updateById(StyleShow styleShow) {
        return styleShowMapper.updateByPrimaryKey(styleShow);
    }

    @Override
    public void insertOne(StyleShow styleShow) {
        InsertUtil.setDefaultValue(styleShow);
        styleShowMapper.insert(styleShow);

    }

    /**
     * 逻辑删除  根据 ID
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        StyleShow record = styleShowMapper.selectByPrimaryKey(id);
        //设置逻辑删除
        record.setDeleteStatus(true);
        //更新回 数据库
        styleShowMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据比赛 ID 获取部落风采展示的届数
     *
     * @param compId
     * @return
     */
    @Override
    public Result<List<Integer>> getAllStyleShowYears(Integer compId) {
        return Result.success(styleShowMapperCustom.getAllTheYearByCompetitionId(compId));
    }

    /**
     * 根据比赛 ID 获取部落风采展示的届数
     * 代替上面接口
     *
     * @param compId
     * @return
     */
    @Override
    public Result<List<CompetitionYear>> getAllCompetitionYear(Integer compId) {
        CompetitionYearExample x = new CompetitionYearExample();
        x.createCriteria()
                .andCompetitionIdEqualTo(compId);
        //获取比赛 id 下面 的 比赛届数
        final List<CompetitionYear> competitionYears = competitionYearMapper.selectByExample(x);

        return Result.success(competitionYears);
    }
    // /**
    //  * @param compId 比赛ID
    //  * @return
    //  */
    // @Override
    // public Result<List<NumberOfSessions>> getAllYearsOfCompetition(Integer compId) {
    //     return null;
    // }

    /**
     * @param yearId      第几届    第9届，比如  的 ID
     * @param competitionId 比赛 ID ,蓝桥杯，软设等
     * @return
     */
    @Override
    public Result<List<StyleShowVO>> getAllStyleShowVOByCompetitionIdAndTheYear(Integer yearId, Integer competitionId) {
        return Result.success(styleShowMapperCustom.getByCompetitionIdAndYearId(competitionId,yearId));
    }

    /**
     * 更新 styleShow  第几届
     *
     * @param info
     */
    @Override
    public void updateOrInsertCompetitionYears(CompetitionYear info) {
        // competitionYearMapper.updateByPrimaryKey()
        if (info.getYearId()==null) {
            if (info.getCompetitionId()==null) {
                throw new ServiceException("对不起，没有 比赛ID",666,"没有比赛ID。。。");
            }
            competitionYearMapper.insertSelective(info);
        }else{
            competitionYearMapper.updateByPrimaryKeySelective(info);
        }
    }

    @Override
    public void deleteStyleShowCompetitionYears(Integer yearID) {
        CompetitionYear ex = new CompetitionYear();
        ex.setYearId( yearID );
        //标记删除
        ex.setDeleteStatus(true);
        competitionYearMapper.updateByPrimaryKeySelective(ex);

    }

    /**
     * 获取所有的 比赛信息 的 第几届
     * @param compId
     * @return
     */
    @Override
    public List<CompetitionYear> getCompetitionYearsByCompetitionId(Integer compId) {
        final CompetitionYearExample competitionYearExample = new CompetitionYearExample();
        competitionYearExample.createCriteria()
                .andCompetitionIdEqualTo(compId);
        return competitionYearMapper.selectByExample(competitionYearExample);

    }

    @Override
    public List<CompetitionAndYearsVO> getCompetitionAndYearsData() {

        return null;
    }

    /**
     * 通过 ID 获取 所有的 风采
     *
     * @param competitionId
     * @return
     */
    @Override
    public List<StyleShow> listStyleShowByCompetition(Integer competitionId) {
        if (competitionId==null) return Collections.emptyList();
        StyleShowExample example = new StyleShowExample();
        //比赛 id = compeId  并且没有被删除的 数据
        example.createCriteria()
                .andCompetitionIdEqualTo((long) competitionId)
                .andDeleteStatusEqualTo(false);

        return styleShowMapper.selectByExample(example);
    }
}
