package com.javatribe.apicompetition.pojo.vo;

import com.javatribe.apicompetition.pojo.dto.YearAndStyleShowVO;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Year;
import java.util.Date;
import java.util.List;

/**
 * 这里打起来了
 * 找前端理论
 * @Author lyr
 * @create 2021/3/26 8:51
 */
@Data
@Accessors(chain = true)
public class YearAndCompetitionVO {

    /**
     * 比赛ID
     */
    private Long competitionId;

    /**
     * 比赛名字
     */
    private String competitionName;

    /**
     * 展示内容
     */
    private String showContent;

    private Boolean deleteStatus;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer signUp;

    private List<YearAndStyleShowVO> yearList;
    // private Date teamBeginTime;
    // private Date teamEndTime;
    // private List<StyleShow> styleList;
}
