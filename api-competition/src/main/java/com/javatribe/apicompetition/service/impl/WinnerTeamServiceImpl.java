package com.javatribe.apicompetition.service.impl;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.WinnerTeamMapper;
import com.javatribe.apicompetition.pojo.po.*;
import com.javatribe.apicompetition.service.WinnerTeamService;
import com.javatribe.apicompetition.util.MatcherRegexUtil;
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
    public List<WinnerTeam> queryWinnerTeamOfCompetition(Long competitionId,Long yearId) {
        List<WinnerTeam> winnerTeamToDisplays = new ArrayList<>();
        //名次  进行排序
        winnerTeamToDisplays = winnerTeamMapper.selectTeamOfCompetition(competitionId,yearId);

        return winnerTeamToDisplays;
    }

    @Override
    public Result addSessionNum(NumberOfSessions sessions) {
        Result result = new Result();
        if (Objects.isNull(sessions.getYearStartTime()) || Objects.isNull(sessions.getYearEndTime()) ||
                StringUtils.isEmpty(sessions.getTheYear())){
            result.setCode(401);
            result.setMessage("届数的名字/开始/结束时间为空，请重新填写");
            return result;
        }
        if (StringUtils.isEmpty(sessions.getCompetitionId())){
            result.setCode(401);
            result.setMessage("届数对应的比赛id不能为空，请重新填写");
            return result;
        }
        if (!MatcherRegexUtil.standardSessionsNum(sessions.getTheYear().trim())){
            result.setCode(401);
            result.setMessage("届数格式出错，格式为【第几届】");
            return result;
        }
        try{
            sessions.setGmtCreate(new Date());
            sessions.setDeleteStatus(0);
            sessions.setActiveStatus(1);
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

    @Override
    public Result editSessionNum(NumberOfSessions sessions) {
        Result result = Result.success();
        if (Objects.isNull(sessions.getYearId())){
            result.setCode(401);
            result.setMessage("修改出错，届数唯一标识为空");
            return result;
        }
        //如果三个需要被修改的值都为空，就不需要执行修改语句
        if (StringUtils.isEmpty(sessions.getTheYear()) &&
                Objects.isNull(sessions.getYearStartTime()) &&
                Objects.isNull(sessions.getYearEndTime())){
            return result;
        }
        if (!StringUtils.isEmpty(sessions.getTheYear()) && !MatcherRegexUtil.standardSessionsNum(sessions.getTheYear().trim())){
            result.setCode(401);
            result.setMessage("届数格式出错，格式为【第几届】");
            return result;
        }
        try {
            sessions.setGmtModified(new Date());
            winnerTeamMapper.editSessionNum(sessions);
        }catch (Exception e){
            result.setCode(401);
            result.setMessage("修改出错");
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    @Override
    public Result querySessionNumByCompetition(Long competitionId) {
        Result result = new Result();
        List<NumberOfSessions> numberOfSessions = winnerTeamMapper.querySessionNumByCompetition(competitionId);
        result.setCode(200);
        result.setData(JSON.toJSONString(numberOfSessions));
        return result;
    }
}
