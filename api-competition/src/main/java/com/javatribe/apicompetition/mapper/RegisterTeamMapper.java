package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import java.util.List;

public interface RegisterTeamMapper {
    int deleteByPrimaryKey(Long registerId);

    int insert(RegisterTeam record);

    RegisterTeam selectByPrimaryKey(Long registerId);

    List<RegisterTeam> selectAll();

    int updateByPrimaryKey(RegisterTeam record);

    List<CompetitionIntroduction> querySignUpKinds();
}