package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.RegisterTeamMapper;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.service.RegisterTeamService;
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

    @Override
    public String toValidateMessage(RegisterTeam registerTeam) {
        //首先判断电话号码
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
}
