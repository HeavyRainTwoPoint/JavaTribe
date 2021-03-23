package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/31 23:27
 */
public interface StyleShowMapperCustom {
    /**
     * @return 获取首页风采展示数据
     */
    List<StyleShowVO> getFirstPage();


    /**
     * 比赛 ID 和 第几届，
     * 获取 部落风采展示
     * @param comId
     * @param theYear
     * @return
     */
    List<StyleShowVO> getByCompetitionIdAndYearId(@Param("comId") Integer comId,@Param("theYear") Integer yearId);

    List<Integer> getAllTheYearByCompetitionId(@Param("comId") Integer comId);
}
