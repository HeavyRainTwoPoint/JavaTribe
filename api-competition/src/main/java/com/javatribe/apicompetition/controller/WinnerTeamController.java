package com.javatribe.apicompetition.controller;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.AllWinnerTeamToDisplay;
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
    public Result listOfWinners(){
        Result result = new Result();
        List<AllWinnerTeamToDisplay> allWinnerTeamToDisplays = new ArrayList<>();
        allWinnerTeamToDisplays = winnerTeamService.queryWinnerTeamOfCompetition();
        result.setCode(200);
        result.setData(JSON.toJSONString(allWinnerTeamToDisplays));
        return result;
    }

    //添加届数
    @PostMapping(value = "/addSession")
    public Result addSessionNum(NumberOfSessions sessions){
        return winnerTeamService.addSessionNum(sessions);
    }

    //添加获奖数据
    @PostMapping(value = "/addGetPrizesData")
    public Result addGetPrizesData(WinnerTeam winnerTeam){
        return winnerTeamService.addGetPrizesData(winnerTeam);
    }

    @PutMapping(value = "/editGetPrizesData")
    public Result editGetPrizesData(WinnerTeam winnerTeam){
        return winnerTeamService.editGetPrizesData(winnerTeam);
    }

    @DeleteMapping(value = "/deleteGetPrizesData")
    public Result deleteGetPrizesData(WinnerTeam winnerTeam){
        return winnerTeamService.deleteGetPrizesData(winnerTeam);
    }

}
