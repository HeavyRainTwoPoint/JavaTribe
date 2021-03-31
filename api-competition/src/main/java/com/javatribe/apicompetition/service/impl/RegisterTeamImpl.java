package com.javatribe.apicompetition.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.mapper.RegisterTeamMapper;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;
import com.javatribe.apicompetition.pojo.po.Student;
import com.javatribe.apicompetition.service.RegisterTeamService;
import com.javatribe.apicompetition.util.StudentIdUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        if (phone==null || phone==""){
            return "请填写手机号码";
        }
        if(!phoneRegex.matcher(phone).matches()){
            return "手机号码错误，请重新填写";
        }
        //其次判断学号
        String regex = "(^"+ StudentIdUtil.getStudentId() +".*?(?:0[1-9]|[1-5][0-9])$)";
        Pattern studentIdRegex = Pattern.compile(regex);
        String teamLeaderStudentId = registerTeam.getTeamLeaderStudentId();
        if (StringUtils.isEmpty(teamLeaderStudentId)){
            return "队长学号未填写";
        }else if (!studentIdRegex.matcher(teamLeaderStudentId.trim()).matches()){
            return "队长学号填写出错，请重新填写";
        }
        if(registerTeam.getTeamUserList()!=null && registerTeam.getTeamUserId()==null) {
            return "队员学号不能为空";
        }else if(registerTeam.getTeamUserId()!=null){
            String[] teamUserIds = registerTeam.getTeamUserId().split(",");
            for (int i=0 ; i<teamUserIds.length ; i++){
                if (!studentIdRegex.matcher(teamUserIds[i].trim()).matches()){
                    return "队员学号填写错误";
                }
            }
        }
        return null;
    }

    @Override
    public String toValidateNoSameNameOrSameLeaderName(RegisterTeam registerTeam) {
        //首先检查是否有同名队伍 规则：在同一届 同一个比赛中 不能存在相同的队伍
        int i = registerTeamMapper.selectSameTeamName(registerTeam.getCompetitionId(), registerTeam.getTeamName(),registerTeam.getRegisterId());
        if (i>0){
            return "队伍名字重复，请重新填写";
        }
        i = registerTeamMapper.selectSameTeamLeaderName(registerTeam.getCompetitionId(),registerTeam.getTeamLeaderName(),registerTeam.getRegisterId());
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

    @Override
    public Result queryRegisterList(Long competitionId) {
        Result result = new Result();
        result.setCode(200);
        List<RegisterTeam> registerTeam = registerTeamMapper.queryRegisterList(competitionId);
        List<RegisterTeamOfFront> datas = new ArrayList<>();
        if (registerTeam!=null && registerTeam.size()!=0){
            for (int i=0 ; i<registerTeam.size() ; i++) {
                RegisterTeam o = registerTeam.get(i);
                RegisterTeamOfFront registerTeamOfFront = new RegisterTeamOfFront();
                registerTeamOfFront.setCompetitionId(o.getCompetitionId());
                registerTeamOfFront.setOrder(o.getOrder());
                registerTeamOfFront.setRegisterId(o.getRegisterId());
                registerTeamOfFront.setTeamLeaderCollege(o.getTeamLeaderCollege());
                registerTeamOfFront.setTeamLeaderName(o.getTeamLeaderName());
                registerTeamOfFront.setTeamLeaderStudentId(o.getTeamLeaderStudentId());
                registerTeamOfFront.setTeamLeaderPhone(o.getTeamLeaderPhone());
                registerTeamOfFront.setTeamLeaderWechat(o.getTeamLeaderWechat());
                registerTeamOfFront.setTeamName(o.getTeamName());
                registerTeamOfFront.setRegisterTime(o.getRegisterTime());
                if (!StringUtils.isEmpty(o.getTeamUserList())) {
                    String[] teamUser = o.getTeamUserList().split(",");
                    String[] teamUserId = o.getTeamUserId().split(",");
                    List<Student> students = new ArrayList<>();
                    for (int j = 0; j < teamUser.length; j++) {
                        Student tempData = new Student();
                        tempData.setStudentId(teamUserId[j]);
                        tempData.setStudentName(teamUser[j]);
                        students.add(tempData);
                    }
                    registerTeamOfFront.setTeamUserList(students);
                }
                datas.add(registerTeamOfFront);
            }
        }
        result.setData(JSON.toJSONString(datas));
        return result;
    }

    @Override
    public Result editRegisterData(RegisterTeamOfFront registerTeam) {
        Result result = new Result();
        if(registerTeam.getRegisterId()==null){
            result.setMessage("需要填写比赛id");
            result.setCode(401);
            return result;
        }
        RegisterTeam registerTeamOfData = new RegisterTeam(registerTeam.getRegisterId(), registerTeam.getCompetitionId(), registerTeam.getTeamName(), registerTeam.getTeamLeaderName(), registerTeam.getTeamLeaderPhone(), registerTeam.getTeamLeaderStudentId(), registerTeam.getTeamLeaderWechat(), registerTeam.getTeamLeaderCollege());
        registerTeamOfData.setRegisterTime(registerTeam.getRegisterTime());
        result = ((RegisterTeamService)AopContext.currentProxy()).validateEditAndSignRegisterTeam(registerTeam, result, "编辑", registerTeamOfData);
        if (result.getCode() != null){
            return result;
        }
        registerTeamMapper.updateByPrimaryKey(registerTeamOfData);
        return Result.success();
    }

    @Override
    public Result deleteRegisterData(Long registerId) {
        registerTeamMapper.deleteByPrimaryKey(registerId);
        return Result.success();
    }

    @Override
    public Result validateEditAndSignRegisterTeam(RegisterTeamOfFront registerTeam,Result result,String type,RegisterTeam registerTeamOfData) {
        String user = "";
        String userId = "";
        //将队员的名字使用，分割，串联起来
        for(int i=0 ; registerTeam.getTeamUserList()!=null&&i<registerTeam.getTeamUserList().size() ; i++){
            Student student = registerTeam.getTeamUserList().get(i);
            if (StringUtils.isEmpty(student.getStudentId()) || StringUtils.isEmpty(student.getStudentName())){
                result.setCode(401);
                result.setMessage("学号和学生姓名传输不对称");
                return result;
            }
            user += (student.getStudentName()+",");
            userId += (student.getStudentId()+",");
        }
        if(user!="") {
            user = user.substring(0, user.length() - 1);
            userId = userId.substring(0,userId.length()-1);
        }
        registerTeamOfData.setTeamUserList(user);
        registerTeamOfData.setTeamUserId(userId);
        //如果编辑的时候手机号码为空，那么就不需要再次判断。
        String message = null;
        if (!(StringUtils.isEmpty(registerTeam.getTeamLeaderPhone()) || (StringUtils.isEmpty(registerTeam.getTeamLeaderPhone())&&"编辑".equals(type)))) {
            message = toValidateMessage(registerTeamOfData);
            if (!Objects.isNull(message)) {
                result.setCode(401);
                result.setMessage(type + "失败：" + message);
                return result;
            }
        }
        registerTeamOfData.setDeleteStatus(0);
        if (!"编辑".equals(type) && registerTeamOfData.getRegisterTime()==null) {
            registerTeamOfData.setRegisterTime(new Date());
        }
        message = toValidateNoSameNameOrSameLeaderName(registerTeamOfData);
        if (!Objects.isNull(message)){
            result.setCode(401);
            result.setMessage(type+"失败："+message);
            return result;
        }
        return result;
    }
}
