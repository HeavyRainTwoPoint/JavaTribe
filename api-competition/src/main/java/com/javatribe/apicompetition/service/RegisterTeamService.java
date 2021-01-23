package com.javatribe.apicompetition.service;

import com.javatribe.apicompetition.pojo.po.RegisterTeam;

public interface RegisterTeamService {


    int insertRegisterTeam(RegisterTeam registerTeam);

    String toValidateMessage(RegisterTeam registerTeam);

}
