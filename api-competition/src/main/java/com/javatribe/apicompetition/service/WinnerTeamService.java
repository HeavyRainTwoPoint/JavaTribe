package com.javatribe.apicompetition.service;

import com.javatribe.apicompetition.pojo.po.AllWinnerTeamToDisplay;

import java.util.List;

public interface WinnerTeamService {

    List<AllWinnerTeamToDisplay> queryWinnerTeamOfCompetition();

}
