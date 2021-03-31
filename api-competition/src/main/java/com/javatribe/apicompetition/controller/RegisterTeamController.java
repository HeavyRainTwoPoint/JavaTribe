package com.javatribe.apicompetition.controller;

import com.alibaba.fastjson.JSON;
import com.javatribe.apicompetition.aop.annotation.ActionHandler;
import com.javatribe.apicompetition.mapper.RegisterTeamMapper;
import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;
import com.javatribe.apicompetition.service.RegisterTeamService;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.javatribe.apicommon.dto.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/competition")
@ResponseBody
@Controller
public class RegisterTeamController {

    @Autowired
    private RegisterTeamMapper registerTeamMapper;
    @Autowired
    RegisterTeamService registerTeamService;

    private static Logger logger = LoggerFactory.getLogger(RegisterTeamController.class);

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

    /**
     * 进行报名
     * @param registerTeam
     * @return
     */
    @RequestMapping(value = "/sign_up",method = RequestMethod.POST)
    public Result singUp(@RequestBody RegisterTeamOfFront registerTeam) {
        Result result = new Result();
        //首先判断是否为空
        String message = registerTeamService.toValidateMessageIsNull(registerTeam);
        if(!Objects.isNull(message)){
            result.setCode(401);
            result.setMessage("报名失败："+message);
            return result;
        }
        RegisterTeam registerTeamOfData = new RegisterTeam(registerTeam.getRegisterId(), registerTeam.getCompetitionId(), registerTeam.getTeamName(), registerTeam.getTeamLeaderName(), registerTeam.getTeamLeaderPhone(), registerTeam.getTeamLeaderStudentId(), registerTeam.getTeamLeaderWechat(), registerTeam.getTeamLeaderCollege());
        result = registerTeamService.validateEditAndSignRegisterTeam(registerTeam,result,"报名",registerTeamOfData);
        if (result.getCode() != null){
            return result;
        }
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

    /**
     * 获取比赛的报名列表
     * @return
     */
    @GetMapping("/registerList")
    @ActionHandler
    public Result queryRegisterList(@RequestParam("competitionId") Long competitionId){
        return registerTeamService.queryRegisterList(competitionId);
    }

    @PutMapping("/editRegisterData")
    @ActionHandler
    public Result editRegisterData(@RequestBody RegisterTeamOfFront registerTeamOfFront){
        return registerTeamService.editRegisterData(registerTeamOfFront);
    }

    @DeleteMapping("/deleteRegisterData")
    @ActionHandler
    public Result deleteRegisterData(Long registerId){
        return registerTeamService.deleteRegisterData(registerId);
    }

    @PostMapping("/addRegisterData")
    @ActionHandler
    public void addRegisterData(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("sign_up").forward(request,response);
        } catch (ServletException e) {
            logger.error(e.getMessage(),e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }

}
