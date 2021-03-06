package com.javatribe.apilife.service;


import com.javatribe.apilife.pojo.Activity;

import java.util.List;

public interface LifeInfoQueryService {

    boolean isExistTitle(String title);


    List<Activity> listActivitiesByPriority();

    Activity queryById(Integer id);

    Activity queryByActTitle(String title);

    List<Activity> afresh();
}
