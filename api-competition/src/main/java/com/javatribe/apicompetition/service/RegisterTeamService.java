package com.javatribe.apicompetition.service;

import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;

public interface RegisterTeamService {


    int insertRegisterTeam(RegisterTeam registerTeam);

    String toValidateMessage(RegisterTeam registerTeam);

    String toValidateNoSameNameOrSameLeaderName(RegisterTeam registerTeam);

    String toValidateMessageIsNull(RegisterTeamOfFront registerTeam);

}
