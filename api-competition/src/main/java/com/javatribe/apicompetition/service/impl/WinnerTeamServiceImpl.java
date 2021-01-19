package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.WinnerTeamMapper;
import com.javatribe.apicompetition.pojo.po.*;
import com.javatribe.apicompetition.service.WinnerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WinnerTeamServiceImpl implements WinnerTeamService {

    @Autowired
    WinnerTeamMapper winnerTeamMapper;

    @Override
    public List<AllWinnerTeamToDisplay> queryWinnerTeamOfCompetition() {
        List<AllWinnerTeamToDisplay> allWinnerTeamToDisplays = new ArrayList<>();
        //查出来的用户会根据 competitionid -->  开始时间  -->  名次  进行排序
        List<WinnerTeamAndCompetition> winnerTeamAndCompetitions = winnerTeamMapper.selectTeamOfCompetition();
        //计算出比赛的种类
        List<Long> competitionStreams = winnerTeamAndCompetitions.stream().map(o->o.getCompetitionId()).distinct().collect(Collectors.toList());
        for(int i=0 ; i<competitionStreams.size() ; i++){
            //进行处理数据格式
            Long competitionId = competitionStreams.get(i);
            //首先找到不同类别的比赛
            List<WinnerTeamAndCompetition> collect = winnerTeamAndCompetitions.stream().filter(o -> o.getCompetitionId() == competitionId).collect(Collectors.toList());
            if(collect==null || collect.size()==0){
                continue;
            }
            AllWinnerTeamToDisplay temp = new AllWinnerTeamToDisplay();
            //设置比赛名字
            temp.setCompetitionNames(collect.get(0).getCompetitionName());
            //设置时间
            List<DateTimes> dateTimes = collect.stream().map(o -> {
                DateTimes dates = new DateTimes();
                dates.setName(o.getTheYear());
                dates.setStartTime(o.getTeamBeginTime());
                dates.setEndTime(o.getTeamEndTime());
                return dates;
            }).distinct().collect(Collectors.toList());
            temp.setDates(dateTimes);
            //设置比赛的等级以及内容
            List<WinnerTeamsAndPrizes> winnerTeamsAndPrizesList = new ArrayList<>();
            Map<String, List<WinnerTeamAndCompetition>> listMap = collect.stream().collect(Collectors.groupingBy(WinnerTeamAndCompetition::getTheYear));
            for(Map.Entry<String,List<WinnerTeamAndCompetition>> entry:listMap.entrySet()){
                List<WinnerTeamAndCompetition> value = entry.getValue();
                Map<String, List<WinnerTeamAndCompetition>> winners = value.stream().collect(Collectors.groupingBy(WinnerTeamAndCompetition::getTeamOrderText));
                WinnerTeamsAndPrizes winnerTeamsAndPrizes = new WinnerTeamsAndPrizes();
                winnerTeamsAndPrizes.setGradeOfPrizes(winners.keySet().stream().collect(Collectors.toList()));
                List<WinnerTeams> winnerTeamsList = new ArrayList<>();
                for(List<WinnerTeamAndCompetition> competitions : winners.values()){
                    WinnerTeams winnerTeams = new WinnerTeams();
                    winnerTeams.setWinnerTeams(competitions.stream().map(o->{
                        WinnerTeam winnerTeam = new WinnerTeam();
                        winnerTeam.setTeamName(o.getTeamName());
                        winnerTeam.setTeamUserList(o.getTeamUserList());
                        winnerTeam.setTeamOrder(o.getTeamOrderText());
                        return winnerTeam;
                    }).collect(Collectors.toList()));
                    System.out.println(Arrays.toString(winnerTeams.getWinnerTeams().toArray()));
                    winnerTeamsList.add(winnerTeams);
                }
                winnerTeamsAndPrizes.setWinnerTeams(winnerTeamsList);
                winnerTeamsAndPrizesList.add(winnerTeamsAndPrizes);
            }
            temp.setTeamsAndPrizes(winnerTeamsAndPrizesList);
            allWinnerTeamToDisplays.add(temp);
        }

        return allWinnerTeamToDisplays;
    }
}
