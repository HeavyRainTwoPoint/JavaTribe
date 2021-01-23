package com.javatribe.apicompetition.controller;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicompetition.mapper.RegisterTeamMapper;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;
import com.javatribe.apicompetition.service.RegisterTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.javatribe.apicommon.dto.*;

@RequestMapping("/competition")
@ResponseBody
@Controller
public class RegisterTeamController {

    @Autowired
    private RegisterTeamMapper registerTeamMapper;
    @Autowired
    RegisterTeamService registerTeamService;

    /**
     * 获取 报名入口 中 报名的种类
     * @return
     */
    @RequestMapping("/signUpKindsGet")
    public Result toGetSignUpKind(){
        Result result = new Result();
        List<CompetitionIntroduction> competitionIntroductions = registerTeamMapper.querySignUpKinds();
        result.setCode(200);
        result.setData(JSON.toJSONString(competitionIntroductions));
        return result;
    }


    @RequestMapping(value = "/sign_up",method = RequestMethod.POST)
    public Result singUp(RegisterTeamOfFront registerTeam) {
        Result result = new Result();
        RegisterTeam registerTeamOfData = new RegisterTeam(registerTeam.getRegisterId(), registerTeam.getCompetitionId(), registerTeam.getTeamName(), registerTeam.getTeamLeaderName(), registerTeam.getTeamLeaderPhone(), registerTeam.getTeamLeaderStudentId(), registerTeam.getTeamLeaderWechat(), registerTeam.getTeamLeaderCollege());
        String user = "";
        for (String temp : registerTeam.getTeamUserList()) {
            user = user + temp + ",";
        }
        String message = registerTeamService.toValidateMessage(registerTeamOfData);
        if(!Objects.isNull(message)){
            result.setCode(401);
            result.setMessage("报名失败："+message);
            return result;
        }
        registerTeamOfData.setDeleteStatus(0);
        registerTeamOfData.setRegisterTime(new Date());
        user = user.substring(0, user.length() - 1);
        registerTeamOfData.setTeamUserList(user);
        int i = registerTeamService.insertRegisterTeam(registerTeamOfData);
        if (i > 0) {
            result.setCode(200);
            result.setMessage("报名成功");
        } else {
            result.setCode(401);
            result.setMessage("报名失败，请重新尝试");
        }
        return result;
    }
}
