package com.javatribe.apilife.service.impl;

import com.javatribe.apilife.cache.Cache;
import com.javatribe.apilife.dao.ActivityDao;
import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.service.LifeInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Service
public class LifeInfoQueryServiceImpl implements LifeInfoQueryService {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    Cache cache;

    @PostConstruct
    public void postConstruct() {
        final List<Activity> list = activityDao.selectAll();
        HashMap<Integer, Activity> idMap = new HashMap<>(list.size());
        HashMap<String, Activity> titleMap = new HashMap<>(list.size());
        list.forEach(activity -> {
            idMap.put(activity.getId(), activity);
            titleMap.put(activity.getActTitle(), activity);
        });
        cache.setActivities(list);
        cache.setIdMap(idMap);
        cache.setTitleMap(titleMap);
    }

    @Override
    public boolean isExistTitle(String title) {
        int count = activityDao.isExistTitle(title);
        return count == 1;
    }

    @Override
    public List<Activity> listActivitiesByPriority() {
        return cache.getList();
    }

    @Override
    public Activity queryById(Integer id) {
        return cache.getById(id);
    }

    @Override
    public Activity queryByActTitle(String title) {
        return cache.getByTitle(title);
    }

    @Override
    public List<Activity> afresh() {
        postConstruct();
        return cache.getList();
    }

}
