package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.RegisterTeamMapper;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;
import com.javatribe.apicompetition.service.RegisterTeamService;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Transactional
@Service
public class RegisterTeamImpl implements RegisterTeamService {

    @Autowired
    private RegisterTeamMapper registerTeamMapper;

    @Override
    public int insertRegisterTeam(RegisterTeam registerTeam) {
        return registerTeamMapper.insert(registerTeam);
    }

    /**
     * 判断基本信息是否正确
     * @param registerTeam
     * @return
     */
    @Override
    public String toValidateMessage(RegisterTeam registerTeam) {
        String phone = registerTeam.getTeamLeaderPhone();
        Pattern phoneRegex = Pattern.compile("^1[358]\\d{9}$",Pattern.CASE_INSENSITIVE);
        if(!phoneRegex.matcher(phone).matches()){
            return "手机号码错误，请重新填写";
        }
        //其次判断学号
//        String studentId = registerTeam.getTeamLeaderStudentId();
//        if(){
//            return "队长学号填写出错，请重新填写";
//        }
        return null;
    }

    @Override
    public String toValidateNoSameNameOrSameLeaderName(RegisterTeam registerTeam) {
        //首先检查是否有同名队伍 规则：在同一届 同一个比赛中 不能存在相同的队伍
        String year = DateUtils.formatDate(registerTeam.getRegisterTime(),"yyyy");
        int i = registerTeamMapper.selectSameTeamName(year, registerTeam.getCompetitionId(), registerTeam.getTeamName());
        if (i>0){
            return "队伍名字重复，请重新填写";
        }
        i = registerTeamMapper.selectSameTeamLeaderName(year,registerTeam.getCompetitionId(),registerTeam.getTeamLeaderName());
        if (i>0){
            return "您作为队长已经报过名了，请勿重复报名";
        }
        return null;
    }

    @Override
    public String toValidateMessageIsNull(RegisterTeamOfFront registerTeam) {
        if (registerTeam.getTeamName()==null){
            return "队伍名字为空";
        }
        if (registerTeam.getTeamLeaderName()==null){
            return "队长名字必须填写";
        }
        return null;
    }
}
