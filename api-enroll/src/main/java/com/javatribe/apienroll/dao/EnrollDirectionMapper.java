package com.javatribe.apienroll.dao;

import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import java.util.List;

public interface EnrollDirectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnrollDirection record);

    int insertSelective(EnrollDirection record);

    List<EnrollDirection> selectByExample(EnrollDirectionQTO example);

    EnrollDirection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnrollDirection record);

    int updateByPrimaryKey(EnrollDirection record);
}