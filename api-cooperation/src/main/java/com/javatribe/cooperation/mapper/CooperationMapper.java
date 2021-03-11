package com.javatribe.cooperation.mapper;

import com.javatribe.cooperation.bean.entity.Cooperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CooperationMapper {
    void insert(@Param("cooperation") Cooperation cooperation);
    void update(@Param("cooperation") Cooperation cooperation);
    void delete(@Param("cooperationId") int cooperationId);
    Cooperation selectById(@Param("cooperationId") int cooperationId);
    List<Cooperation> getByPages(@Param("start") int start, @Param("end") int end,@Param("type") Integer type);
    List<Cooperation> getAll(@Param("type") Integer type);
    int getCounts();
}
