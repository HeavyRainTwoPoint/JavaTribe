package com.javatribe.apicompetition.service;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;

import java.util.List;

/**
 * 部落风采
 * @Author lyr
 * @create 2021/1/16 15:49
 */
public interface TribeStyleShowService {

    /**
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
    Result<List<Integer>> getAllStyleShowYears(Integer compId);

    /**
     *
     * @param theYear       第几届    第9届，比如
     * @param competitionId  比赛 ID ,蓝桥杯，软设等
     * @return
     */
    Result<List<StyleShowVO> > getAllStyleShowVOByCompetitionIdAndTheYear(String theYear ,Integer competitionId);

}
