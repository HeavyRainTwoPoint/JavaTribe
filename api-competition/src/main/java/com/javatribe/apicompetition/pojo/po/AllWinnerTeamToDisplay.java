package com.javatribe.apicompetition.pojo.po;

import java.util.List;

/**
 * 用于所有的信息展示
 *
 * [
 *     competitionNames:蓝桥杯,
 *     dates;{
 *      date:[
 *      {
 *          name:"第九届",
 *          startTime:"2020.10.4",
 *          endTime:"2020.11.21"
 *      },
 *      {
 *          ......
 *      }
 *      ]
 *     },
 *     teamsAndPrizes:[
 *      gradeOfPrizes:["一等奖","二等奖",""三等奖],
 *      winnerTeams:[
 *          {
 *              name:"一等奖",
 *              teamName:"队伍名字",
 *              peopleName:"队伍成员名字，以逗号分割"
 *          }
 *      ]
 *     ]
 *
 * ]
 */

public class AllWinnerTeamToDisplay {

    //表示比赛的种类
    private String competitionNames;

    //对应比赛种类的获奖名单
    private List<DateTimes> dates;

    private List<WinnerTeamsAndPrizes> teamsAndPrizes;

    public String getCompetitionNames() {
        return competitionNames;
    }

    public void setCompetitionNames(String competitionNames) {
        this.competitionNames = competitionNames;
    }

    public List<DateTimes> getDates() {
        return dates;
    }

    public void setDates(List<DateTimes> dates) {
        this.dates = dates;
    }

    public List<WinnerTeamsAndPrizes> getTeamsAndPrizes() {
        return teamsAndPrizes;
    }

    public void setTeamsAndPrizes(List<WinnerTeamsAndPrizes> teamsAndPrizes) {
        this.teamsAndPrizes = teamsAndPrizes;
    }
}
