package com.javatribe.apicompetition.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.pojo.vo.StyleShowVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author lyr
 * @create 2021/3/26 9:07
 */
@Data
public class YearAndStyleShowVO {

    private Integer yearId;

    /**
     * 第几届
     */
    private Integer theYear;
    @JsonIgnore
    private Boolean deleteStatus;

    private Integer activeStatus;

    private Date gmtCreate;

    private Date gmtModified;

    /**
     * 开始时间
     */
    private Date yearStartTime;

    /**
     * 结束时间
     */
    private Date yearEndTime;

    private Integer competitionId;

    /**
     * 展示顺序
     */
    private Integer showOrder;


    /**
     * 风采展示队伍
     */
    private List<StyleShowVO> styleShowList;
}
