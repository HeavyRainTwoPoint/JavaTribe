package com.javatribe.apicompetition.util;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.StyleShow;

import java.util.Date;

/**
 * @Author lyr
 * @create 2021/1/31 23:36
 */
public class InsertUtil {


    /**
     * 插入数据时候设置默认值，懒得改代码了
     * @param styleShow
     */
    public static void setDefaultValue(StyleShow styleShow) {
        if (styleShow==null) {
            return;
        }
        HtmlUtil.escapeHtml(styleShow);
        styleShow.setDeleteStatus(false);
        styleShow.setShowStatus(true);
        styleShow.setGmtCreate(new Date());
        styleShow.setGmtModified(new Date());
    }

    /**
     * 插入展示 比赛介绍时候，设置 逻辑删除等默认值
     * @param competitionIntroduction
     */
    public static void setDefaultValue(CompetitionIntroduction competitionIntroduction) {
        if (competitionIntroduction==null) {
            return;
        }
        HtmlUtil.escapeHtml(competitionIntroduction);
        competitionIntroduction.setDeleteStatus(false);
        competitionIntroduction.setGmtCreate(new Date());
        competitionIntroduction.setGmtModified(new Date());
    }

}
