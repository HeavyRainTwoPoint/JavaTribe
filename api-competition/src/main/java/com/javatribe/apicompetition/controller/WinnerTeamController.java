package com.javatribe.apicompetition.controller;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.AllWinnerTeamToDisplay;
import com.javatribe.apicompetition.service.WinnerTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
