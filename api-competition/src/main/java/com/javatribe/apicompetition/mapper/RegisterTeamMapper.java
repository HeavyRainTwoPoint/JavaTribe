package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterTeamMapper {
    int deleteByPrimaryKey(Long registerId);

    int insert(RegisterTeam record);

    RegisterTeam selectByPrimaryKey(Long registerId);

    List<RegisterTeam> selectAll();

    int updateByPrimaryKey(RegisterTeam record);

    List<CompetitionIntroduction> querySignUpKinds();
}