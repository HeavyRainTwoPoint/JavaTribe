package com.javatribe.apicompetition.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @Author lyr
 * @create 2021/3/7 12:57
 */
@Data
@Accessors(chain = true)
public class CompetitionIntroductionDTO {

    /**
     * 可以为空，不为空就更新
     */
    private Long competitionId;
    // @NotBlank(message = "比赛名字不能为空")
    private String competitionName;
    // @NotBlank(message = "比赛介绍不能为空")
    private String showContent;
    /**
     * 是否可以通过官网报名
     */
    private Integer signUp;
}
