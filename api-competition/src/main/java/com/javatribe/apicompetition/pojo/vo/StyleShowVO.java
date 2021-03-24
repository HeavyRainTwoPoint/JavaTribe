package com.javatribe.apicompetition.pojo.vo;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author lyr
 * @create 2021/3/7 14:07
 */
@Data
@Accessors(chain = true)
public class StyleShowVO {
    private Long showId;

    private Long competitionId;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean showStatus;

    private Boolean deleteStatus;

    private Integer showOrder;

    private String imgs;

    private String projectName;

    private String teamName;

    private String teamMembers;

    private Date teamBeginTime;

    private Date teamEndTime;

    private String theYear;

    private Integer yearId;
    private Integer signUp;


    private String competitionName;
    // private StyleShow styleShow;
    // private CompetitionIntroduction competition;
}
