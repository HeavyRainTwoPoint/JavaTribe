package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.WinnerTeam;
import com.javatribe.apicompetition.pojo.po.WinnerTeamAndCompetition;

import java.util.List;

public interface WinnerTeamMapper {
    int insert(WinnerTeam record);

    List<WinnerTeam> selectAll();

    List<WinnerTeamAndCompetition> selectTeamOfCompetition();
}