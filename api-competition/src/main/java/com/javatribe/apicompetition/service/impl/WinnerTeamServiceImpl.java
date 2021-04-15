package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.enumeration.PrizeEnum;
import com.javatribe.apicompetition.mapper.WinnerTeamMapper;
import com.javatribe.apicompetition.pojo.po.NumberOfSessions;
import com.javatribe.apicompetition.pojo.po.WinnerTeam;
import com.javatribe.apicompetition.service.WinnerTeamService;
import com.javatribe.apicompetition.util.MatcherRegexUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        int order = PrizeEnum.getOrder(winnerTeam.getTeamOrder());
        if (order==-1){
            result.setCode(401);
            result.setMessage("奖项是必填，操作失败");
            return result;
        }
        winnerTeam.setTeamOrderNum(order);
        winnerTeam.setTeamOrderText(winnerTeam.getTeamOrder());
        winnerTeam.setGmtCreate(new Date());
        winnerTeam.setGmtModified(new Date());
        winnerTeamMapper.addGetPrizesData(winnerTeam);
        return Result.success();
    }

    @Override
    public Result editGetPrizesData(WinnerTeam winnerTeam) {
        //根据 teamId 和 theYear和比赛id
        Result result = Result.success();
        if (Objects.isNull(winnerTeam.getPrizeId())){
            result.setCode(401);
            result.setMessage("修改出错，获奖队伍唯一标识为空");
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
        int order = PrizeEnum.getOrder(winnerTeam.getTeamOrder());
        //如果三个必须要修改的数据，都无需修改，那么直接返回
        if (StringUtils.isEmpty(winnerTeam.getTeamName())&&StringUtils.isEmpty(winnerTeam.getTeamUserList())&&(order==-1)){
            return result;
        }
        if (order!=-1){
            winnerTeam.setTeamOrderNum(order);
            winnerTeam.setTeamOrderText(winnerTeam.getTeamOrder());
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
        if (Objects.isNull(winnerTeam.getPrizeId())){
            result.setCode(401);
            result.setMessage("删除出错，获奖队伍唯一标识为空");
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
}
