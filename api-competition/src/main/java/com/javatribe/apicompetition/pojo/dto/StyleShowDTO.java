package com.javatribe.apicompetition.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 部落风彩展示
 * @Author lyr
 * @create 2021/3/7 13:12
 */
@Data
public class StyleShowDTO {
    private Long showId;

    /**
     * 比赛ID
     */
    private Long competitionId;
    /**
     * 1 就暂时，0就不展示到前端了
     */
    private Boolean showStatus;

    /**
     * 展示优先级
     */
    private Integer showOrder;

    /**
     * 图片，逗号分隔
     */
    private String imgs;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 队伍名字
     */
    private String teamName;

    /**
     * 队伍成员，逗号分隔
     */
    private String teamMembers;

    /**
     * 第几届
     * 产品那里设计不清楚，这里留个 冗余字段这里，后期考虑删除这个
     * 通过 yearId 连表查询
     */
    private String theYear;

    /**
     * 第几届的 ID
     */
    @NotNull(message = "yearId 不能为空")
    private Integer yearId;


    /**
     * 队伍开始时间
     *
     */
    private Date teamBeginTime;

    /**
     * 队伍比赛结束时间
     *
     */
    private Date teamEndTime;
}
