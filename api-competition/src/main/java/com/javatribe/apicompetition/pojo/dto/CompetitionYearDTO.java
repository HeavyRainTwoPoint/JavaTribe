package com.javatribe.apicompetition.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 前端 转过来的数据
 * @Author lyr
 * @create 2021/4/1 14:59
 */
@Data
public class CompetitionYearDTO {

    private Integer yearId;

    private Integer theYear;
    @JsonIgnore
    private Boolean deleteStatus;
    @JsonIgnore
    private Integer activeStatus;

    private Date gmtCreate;

    private Date gmtModified;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy 年 MM 月 dd 日")
    private Date yearStartTime;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy 年 MM 月 dd 日")
    private Date yearEndTime;

    private Integer competitionId;

    private Integer showOrder;
}
