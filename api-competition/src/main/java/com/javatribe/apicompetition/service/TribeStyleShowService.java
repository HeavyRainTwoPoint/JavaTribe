package com.javatribe.apicompetition.service;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.dto.StyleShowDTO;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.pojo.po.NumberOfSessions;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.CompetitionAndYearsVO;
import com.javatribe.apicompetition.pojo.vo.FrontStyleShowVO;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;

import java.util.List;

/**
 * 部落风采
 * @Author lyr
 * @create 2021/1/16 15:49
 */
public interface TribeStyleShowService {
    /**
     * 部落官网前端 获取风采展示
     * @return
     */
    List<FrontStyleShowVO> getAllStyleShowFronted();

    /**
     * 管理员端
     * @return 部落官网首页获取风采展示
     */
    List<StyleShowVO> getAllStyleShow();

    /**
     * 更新风采展示
     * @param styleShow
     * @return
     */
    int updateById(StyleShow styleShow);


    /**
     * @param styleShow 插入一条数据，风采展示
     */
    void insertOne(StyleShow styleShow);


    /**
     * 逻辑删除  根据 ID
     * @param id
     */
    void deleteById(Long id);


    /**
     * 根据比赛 ID 获取部落风采展示的届数
     * @param compId
     * @return
     */
    @Deprecated
    Result<List<Integer>> getAllStyleShowYears(Integer compId);

    /**
     * 根据比赛 ID 获取部落风采展示的届数
     * 代替上面接口
     * @param compId
     * @return
     */
    Result<List<CompetitionYear> > getAllCompetitionYear(Integer compId);

    /**
     * @param compId  比赛ID
     * @return
     */
    // Result<List<NumberOfSessions>> getAllYearsOfCompetition(Integer compId);

    /**
     *
     * @param theYear       第几届    第9届，比如
     * @param competitionId  比赛 ID ,蓝桥杯，软设等
     * @return
     */
    Result<List<StyleShowVO> > getAllStyleShowVOByCompetitionIdAndTheYear(Integer yearId ,Integer competitionId);


    /**
     * 更新 styleShow  第几届
     * @param yearId
     */
    void updateOrInsertCompetitionYears(CompetitionYear info);

    /**
     * 删除对应的届数
     * @param yearID
     */
    void deleteStyleShowCompetitionYears(Integer yearID);

    List<CompetitionYear> getCompetitionYearsByCompetitionId(Integer compId);


    /**
     * 获取比赛 以及对于的届数
     * @return
     */
    List<CompetitionAndYearsVO> getCompetitionAndYearsData();


    /**
     * 通过 ID 获取 所有的 风采
     * @param competitionId
     * @return
     */
    List<StyleShow> listStyleShowByCompetition(Integer competitionId);


    /**
     * @param yearNum 第几届
     * @param compId  比赛ID
     * @return
     */
    CompetitionYear getYearByCompetitionIdAndYearText(Integer yearNum,Integer compId);


    /**
     * 自动生成前端 的风采展示的 第几届
     * @param styleShow
     */
    void resetYearId(StyleShowDTO styleShow);
}
