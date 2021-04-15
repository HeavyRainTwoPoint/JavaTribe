package com.javatribe.apicompetition.service;

import com.javatribe.apicommon.dto.Result;
import com.javatribe.apicompetition.pojo.po.NumberOfSessions;
import com.javatribe.apicompetition.pojo.po.WinnerTeam;

import java.util.List;

public interface WinnerTeamService {

    List<WinnerTeam> queryWinnerTeamOfCompetition(Long competitionId,Long yearId);

    Result addGetPrizesData(WinnerTeam winnerTeam);

    Result editGetPrizesData(WinnerTeam winnerTeam);

    Result deleteGetPrizesData(WinnerTeam winnerTeam);

    Result editSessionNum(NumberOfSessions sessions);
}
