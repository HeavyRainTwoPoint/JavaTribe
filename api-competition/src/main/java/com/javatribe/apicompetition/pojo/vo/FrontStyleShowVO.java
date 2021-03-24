package com.javatribe.apicompetition.pojo.vo;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.CompetitionYear;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import lombok.Data;

/**
 * @Author lyr
 * @create 2021/3/24 21:32
 */
@Data
// @Accessors(chain = true)

public class FrontStyleShowVO {
    // private Integer showId;
    private StyleShow styleShow;
    private CompetitionIntroduction competition;
    private CompetitionYear year;

}
