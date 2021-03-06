package com.javatribe.apilife.service;

import com.javatribe.apilife.dto.ActivityDTO;
import com.javatribe.apilife.pojo.Activity;

public interface LifeInfoManipulation {

    void insertActivity(ActivityDTO dto);

    void updateActivityByTitle(ActivityDTO dto);

    void updateActivityById(ActivityDTO dto);

    void deleteActivityById(int id);

    void deleteActivityByTitle(String title);

    void priorityMoveUp(int id);

    void priorityMoveDown(int id);

    void prioritySwap(int a, int b);
}
