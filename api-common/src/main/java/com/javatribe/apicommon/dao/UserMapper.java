package com.javatribe.apicommon.dao;

import com.javatribe.apicommon.entity.User;
import com.javatribe.apicommon.entity.UserQTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserQTO example);

    int deleteByExample(UserQTO example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserQTO example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserQTO example);

    int updateByExample(@Param("record") User record, @Param("example") UserQTO example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}