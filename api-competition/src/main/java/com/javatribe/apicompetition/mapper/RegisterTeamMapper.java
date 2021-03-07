package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.CompetitionIntroduction;
import com.javatribe.apicompetition.pojo.po.RegisterTeam;
import org.apache.ibatis.annotations.Param;
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

    int selectSameTeamName(@Param("year") String year, @Param("competitionId") Long competitionId, @Param("teamName") String teamName);

    int selectSameTeamLeaderName(@Param("year") String year,@Param("competitionId") Long competitionId,@Param("teamLeaderName") String teamLeaderName);

    List<RegisterTeam> queryRegisterList(@Param("competitionId") Long competitionId);
}