package com.javatribe.apicompetition.pojo.vo;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import lombok.Data;

/**
 * @Author lyr
 * @create 2021/3/7 14:07
 */
@Data
public class StyleShowVO {
    private StyleShow styleShow;
    private CompetitionIntroduction competition;
}
