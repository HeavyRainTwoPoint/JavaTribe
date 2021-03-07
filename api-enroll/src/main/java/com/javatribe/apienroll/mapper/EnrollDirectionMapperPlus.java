package com.javatribe.apienroll.mapper;

import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnrollDirectionMapperPlus {
    List<EnrollDirection> getLastNItemsOnPerDirection(@Param("n") Integer n);
}