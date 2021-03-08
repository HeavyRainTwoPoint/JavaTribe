package com.javatribe.apicompetition.service;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.RegisterTeamOfFront;

public interface RegisterTeamService {


    int insertRegisterTeam(RegisterTeam registerTeam);

    String toValidateMessage(RegisterTeam registerTeam);

    String toValidateNoSameNameOrSameLeaderName(RegisterTeam registerTeam);

    String toValidateMessageIsNull(RegisterTeamOfFront registerTeam);

    Result queryRegisterList(Long competitionId);

    Result editRegisterData(RegisterTeamOfFront registerTeamOfFront);

    Result deleteRegisterData(Long registerId);

    Result validateEditAndSignRegisterTeam(RegisterTeamOfFront registerTeam,Result result,String type,RegisterTeam registerTeamOfData);

}
