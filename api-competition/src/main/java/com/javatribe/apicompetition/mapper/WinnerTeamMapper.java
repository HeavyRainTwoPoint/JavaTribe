package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.NumberOfSessions;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import com.javatribe.apicompetition.pojo.po.WinnerTeam;
import com.javatribe.apicompetition.pojo.po.WinnerTeamAndCompetition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WinnerTeamMapper {
    int insert(WinnerTeam record);

    List<WinnerTeam> selectAll();

    List<WinnerTeamAndCompetition> selectTeamOfCompetition();

    int addSessionNum(NumberOfSessions numberOfSessions);

    RegisterTeam queryRegisterTeamByNameAndTheYear(@Param("teamName") String teamName,
                                                   @Param("year") String year, @Param("competitionId") Long competitionId);

    int addGetPrizesData(WinnerTeam winnerTeam);

    int updatePrizesData(WinnerTeam winnerTeam);

    int deletePrizesData(WinnerTeam winnerTeam);

    int editSessionNum(NumberOfSessions sessions);
}