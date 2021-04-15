package com.javatribe.apicompetition.controller;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicommon.annotation.AdminAuthentication;
import com.javatribe.apicommon.annotation.TokenFreeAnnotation;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.NumberOfSessions;
import com.javatribe.apicompetition.pojo.po.WinnerTeam;
import com.javatribe.apicompetition.service.WinnerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/competition")
@ResponseBody
@Controller
public class WinnerTeamController {

    @Autowired
    WinnerTeamService winnerTeamService;

    @GetMapping("/listOfWinners")
    @TokenFreeAnnotation
    public Result listOfWinners(Long competitionId,Long yearId){
        Result result = new Result();
        List<WinnerTeam> allWinnerTeamToDisplays = new ArrayList<>();
        allWinnerTeamToDisplays = winnerTeamService.queryWinnerTeamOfCompetition(competitionId,yearId);
        result.setCode(200);
        result.setData(JSON.toJSONString(allWinnerTeamToDisplays));
        return result;
    }

    //添加获奖数据
    @PostMapping(value = "/addGetPrizesData")
    @AdminAuthentication
    public Result addGetPrizesData(@RequestBody WinnerTeam winnerTeam){
        return winnerTeamService.addGetPrizesData(winnerTeam);
    }

    @PutMapping(value = "/editGetPrizesData")
    @AdminAuthentication
    public Result editGetPrizesData(@RequestBody WinnerTeam winnerTeam){
        return winnerTeamService.editGetPrizesData(winnerTeam);
    }

    @DeleteMapping(value = "/deleteGetPrizesData")
    @AdminAuthentication
    public Result deleteGetPrizesData(WinnerTeam winnerTeam){
        return winnerTeamService.deleteGetPrizesData(winnerTeam);
    }

    /**
     * 暂时无用
     * @param sessions
     * @return
     */
    @PutMapping(value = "/editSessionNum")
    @AdminAuthentication
    public Result editSessionNum(NumberOfSessions sessions){
        return winnerTeamService.editSessionNum(sessions);
    }

}
