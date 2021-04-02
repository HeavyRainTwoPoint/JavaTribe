package com.javatribe.apicompetition.service.impl;

import com.github.pagehelper.PageHelper;
import com.javatribe.apicommon.core.constant.enums.ApiInfo;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicommon.exception.BusinessException;
import com.javatribe.apicommon.exception.ServiceException;
import com.javatribe.apicompetition.mapper.CompetitionIntroductionMapperCustom;
import com.javatribe.apicompetition.mapper.CompetitionYearMapper;
import com.javatribe.apicompetition.mapper.StyleShowMapper;
import com.javatribe.apicompetition.mapper.StyleShowMapperCustom;
import com.javatribe.apicompetition.pojo.dto.StyleShowDTO;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        return styleShowMapper.updateByPrimaryKeySelective(styleShow);
    }

    @Override
    public void insertOne(StyleShow styleShow) {
        InsertUtil.setDefaultValue(styleShow);
        styleShowMapper.insertSelective(styleShow);

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
                .andDeleteStatusEqualTo(false)
                .andCompetitionIdEqualTo(compId)

        ;
        PageHelper.orderBy("the_year");
        //获取比赛 id 下面 的 比赛届数
        final List<CompetitionYear> competitionYears = competitionYearMapper.selectByExample(x);
        // Arrays.sort(competitionYears,(CompetitionYear i,CompetitionYear j)->i.getCom);

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
            //如果是插入的话，还要判断  是否插入了重复届数
            //思路： 查询  theYear=theYear and competitionId = compId  and deleteStatus = false
            final CompetitionYearExample queryDTO = new CompetitionYearExample();
            queryDTO.createCriteria()
                    .andDeleteStatusEqualTo(false)
                    .andCompetitionIdEqualTo(info.getCompetitionId())
                    .andTheYearEqualTo( info.getTheYear() );
            //已经有这个届数的话，报异常，阻止重复届数
            final List<CompetitionYear> competitionYears = competitionYearMapper.selectByExample(queryDTO);
            if (competitionYears!=null && competitionYears.size() > 0) {
                //数据不为空
                throw new ServiceException(ApiInfo.BAD_REQUEST,"已经有这一届了，不能重复插入");
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
                //没有被删除的
                .andDeleteStatusEqualTo(false)
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

    /**
     * @param yearNum 第几届
     * @param compId  比赛ID
     * @return
     */
    @Override
    public  CompetitionYear getYearByCompetitionIdAndYearText(Integer yearNum, Integer compId) {
        final CompetitionYearExample competitionYearExample = new CompetitionYearExample();
        competitionYearExample
                .createCriteria()
                .andDeleteStatusEqualTo(false)
                .andCompetitionIdEqualTo(compId)
                .andTheYearEqualTo(yearNum);

        List<CompetitionYear> res =  competitionYearMapper.selectByExample(competitionYearExample);
        if (res==null||res.size()==0) return null;
        return res.get(0);
    }

    /**
     * 自动生成前端 的风采展示的 第几届
     *
     * @param styleShow
     */
    @Override
    public void resetYearId(StyleShowDTO styleShow) {
        //修改 yearId
        int yearId= styleShow.getYearId();
        CompetitionYearExample ex = new  CompetitionYearExample();
        ex.createCriteria()
                .andCompetitionIdEqualTo(styleShow.getCompetitionId().intValue())
                //比赛Id
                .andTheYearEqualTo(yearId);

        final List<CompetitionYear> styleShows = competitionYearMapper.selectByExample(ex);
        if (styleShows==null|| styleShows.size()==0) {
            //没有
            final CompetitionYear competitionYear = new CompetitionYear()
                    .withActiveStatus(1)
                    //比赛ID
                    .withCompetitionId(styleShow.getCompetitionId().intValue())
                    //没有被删除
                    .withDeleteStatus(false)
                    // 年份 届数
                    .withTheYear(yearId);
            competitionYearMapper.insertSelective(
                    competitionYear
            );
            //没有就插入一条 第几届的数据
            styleShow.setYearId(competitionYear.getYearId());

        }else{
            styleShow.setYearId(styleShows.get(0).getYearId());
        }
    }
}
