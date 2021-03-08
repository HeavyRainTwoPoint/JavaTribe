package com.javatribe.apilife.dao;

import com.javatribe.apilife.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface ActivityDao {

    List<Activity> selectAll();

    Activity selectById(@Param("id") int id);

    Activity selectByTitle(@Param("title") String title);

    int insert(Activity activity);

    void updateById(Activity activity);

    void updateByTitle(Activity activity);

    void deleteById(@Param("id") int id);

    int selectIdByTitle(@Param("title") String title);

    int latestPriority();

    int isExistTitle(@Param("title") String title);

    int selectPriorityById(@Param("id") int id);

    Integer selectUpIdByPriority(@Param("priority") int priority);

    void updatePriorityById(@Param("id") int id, @Param("priority") int priority);

    Integer selectDownIdByPriority(int priority);

    int isExistId(@Param("id") int id);
}
