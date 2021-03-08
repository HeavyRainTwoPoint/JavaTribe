package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.WinnerTeamMapper;
import com.javatribe.apicompetition.pojo.po.*;
import com.javatribe.apicompetition.service.WinnerTeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WinnerTeamServiceImpl implements WinnerTeamService {

    @Autowired
    WinnerTeamMapper winnerTeamMapper;


    private static Logger logger = LoggerFactory.getLogger(WinnerTeamServiceImpl.class);

    @Override
    public List<AllWinnerTeamToDisplay> queryWinnerTeamOfCompetition() {
        List<AllWinnerTeamToDisplay> allWinnerTeamToDisplays = new ArrayList<>();
        //查出来的用户会根据 competitionid -->  开始时间[即第几届]  -->  名次  进行排序
        List<WinnerTeamAndCompetition> winnerTeamAndCompetitions = winnerTeamMapper.selectTeamOfCompetition();
        //计算出比赛的种类
        List<Long> competitionStreams = winnerTeamAndCompetitions.stream().map(o->o.getCompetitionId()).distinct().collect(Collectors.toList());
        for(int i=0 ; i<competitionStreams.size() ; i++){
            Long competitionId = competitionStreams.get(i);
            //根据competitionId获取到对应数据
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
            //以第几届作为分组
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

    @Override
    public Result addSessionNum(NumberOfSessions sessions) {
        Result result = new Result();
        if (Objects.isNull(sessions.getYearStartTime()) || Objects.isNull(sessions.getYearEndTime())){
            result.setCode(401);
            result.setMessage("届数的开始/结束时间为空，请重新填写");
            return result;
        }
        try{
            winnerTeamMapper.addSessionNum(sessions);
        }catch (Exception e){
            result.setCode(401);
            result.setMessage("执行出错!!");
            logger.error(e.getMessage(),e);
            return result;
        }
        result.setCode(200);
        result.setMessage("插入届数成功");
        return result;
    }

    @Override
    public Result addGetPrizesData(WinnerTeam winnerTeam) {
        Result result = new Result();
        if (Objects.isNull(winnerTeam.getTheYear())){
            result.setCode(401);
            result.setMessage("届数为空，请重新填写");
            return result;
        }
        if (Objects.isNull(winnerTeam.getCompetitionId())){
            result.setCode(401);
            result.setMessage("比赛传输为空，请求出错");
            return result;
        }
        //添加获奖记录，首先需要判断在数据库中是否有对应的队名
        //根据队伍注册时间与第几届的开始时间 竞赛id 队伍名来判断是否有这个队伍
        String teamName = winnerTeam.getTeamName();
        RegisterTeam registerTeam = winnerTeamMapper.queryRegisterTeamByNameAndTheYear(teamName, winnerTeam.getTheYear(), winnerTeam.getCompetitionId());
        if (Objects.isNull(registerTeam)){
            result.setCode(401);
            result.setMessage("此队伍并未被注册过，禁止添加");
            return result;
        }
        int order = 0;
        if ("一等奖".equals(winnerTeam.getTeamOrder())){
            order = 1;
        }else if ("二等奖".equals(winnerTeam.getTeamOrder())){
            order = 2;
        }else if ("三等奖".equals(winnerTeam.getTeamOrder())){
            order = 3;
        }else{
            order = 4;
        }
        winnerTeam.setTeamOrderNum(order);
        winnerTeam.setTeamOrderText(winnerTeam.getTeamOrder());
        winnerTeam.setTeamId(registerTeam.getRegisterId());
        winnerTeam.setGmtCreate(new Date());
        winnerTeam.setGmtModified(new Date());
        winnerTeamMapper.addGetPrizesData(winnerTeam);
        return Result.success();
    }

    @Override
    public Result editGetPrizesData(WinnerTeam winnerTeam) {
        //根据 teamId 和 theYear和比赛id
        Result result = Result.success();
        if (Objects.isNull(winnerTeam.getTeamId())){
            result.setCode(401);
            result.setMessage("修改出错，队伍唯一标识为空");
            return result;
        }
        if (StringUtils.isEmpty(winnerTeam.getTheYear())){
            result.setCode(401);
            result.setMessage("修改出错，届数为空");
            return result;
        }
        if (Objects.isNull(winnerTeam.getCompetitionId())){
            result.setCode(401);
            result.setMessage("修改出错，比赛唯一标识为空");
            return result;
        }
        if (StringUtils.isEmpty(winnerTeam.getTeamName())&&StringUtils.isEmpty(winnerTeam.getTeamUserList())){
            return result;
        }
        try {
            winnerTeamMapper.updatePrizesData(winnerTeam);
        }catch (Exception e){
            result.setCode(401);
            result.setMessage("执行错误");
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    @Override
    public Result deleteGetPrizesData(WinnerTeam winnerTeam) {
        //根据 teamId 和 theYear和比赛id
        Result result = Result.success();
        if (Objects.isNull(winnerTeam.getTeamId())){
            result.setCode(401);
            result.setMessage("删除出错，队伍唯一标识为空");
            return result;
        }
        if (StringUtils.isEmpty(winnerTeam.getTheYear())){
            result.setCode(401);
            result.setMessage("删除出错，届数为空");
            return result;
        }
        if (Objects.isNull(winnerTeam.getCompetitionId())){
            result.setCode(401);
            result.setMessage("删除出错，比赛唯一标识为空");
            return result;
        }
        try{
            winnerTeamMapper.deletePrizesData(winnerTeam);
        }catch (Exception e){
            result.setCode(401);
            result.setMessage("执行错误");
            logger.error(e.getMessage(),e);
        }
        return result;
    }
}
