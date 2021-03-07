package com.javatribe.apienroll.dao;

import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnrollTestMapper {
    long countByExample(EnrollTestQTO example);

    int deleteByExample(EnrollTestQTO example);

    int deleteByPrimaryKey(Long id);

    int insert(EnrollTest record);

    int insertSelective(EnrollTest record);

    List<EnrollTest> selectByExample(EnrollTestQTO example);

    EnrollTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EnrollTest record, @Param("example") EnrollTestQTO example);

    int updateByExample(@Param("record") EnrollTest record, @Param("example") EnrollTestQTO example);

    int updateByPrimaryKeySelective(EnrollTest record);

    int updateByPrimaryKey(EnrollTest record);
}