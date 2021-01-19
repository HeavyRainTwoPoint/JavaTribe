package com.javatribe.apicompetition.pojo.po;

import java.util.List;

public class WinnerTeamsAndPrizes {

    private List<String> gradeOfPrizes;

    private List<WinnerTeams> winnerTeams;

    public List<String> getGradeOfPrizes() {
        return gradeOfPrizes;
    }

    public void setGradeOfPrizes(List<String> gradeOfPrizes) {
        this.gradeOfPrizes = gradeOfPrizes;
    }

    public List<WinnerTeams> getWinnerTeams() {
        return winnerTeams;
    }

    public void setWinnerTeams(List<WinnerTeams> winnerTeams) {
        this.winnerTeams = winnerTeams;
    }
}
