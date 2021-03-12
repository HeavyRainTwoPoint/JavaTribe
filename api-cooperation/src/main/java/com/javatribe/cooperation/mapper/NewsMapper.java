package com.javatribe.cooperation.mapper;

import com.javatribe.cooperation.bean.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    void insert(@Param("news") News news);
    void update(@Param("news") News news);
    void delete(@Param("newsId") int newsId);
    News selectById(@Param("newsId") int newsId);
    List<News> getByPages(@Param("start") int start, @Param("end") int end);
    List<News> getAll();
    int getCounts(@Param("priority") int priority);
    List<News> getTopNews(@Param("topSize") int topSize);
    List<News> getLowPriorityPage(@Param("start") int start, @Param("end") int end);
    Integer getAllCounts();
}
