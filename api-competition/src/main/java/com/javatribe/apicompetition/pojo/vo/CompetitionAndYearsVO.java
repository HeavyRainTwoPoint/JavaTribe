package com.javatribe.apicompetition.pojo.vo;

import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 前端风采展示格式
 *
 *
 * @Author lyr
 * @create 2021/3/25 0:23
 */
@Data
public class CompetitionAndYearsVO {
    private Long competitionId;

    private String competitionName;

    private String showContent;

    private Boolean deleteStatus;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer signUp;

    List<CompetitionYear> years;
}
