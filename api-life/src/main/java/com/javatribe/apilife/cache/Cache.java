package com.javatribe.apilife.cache;

import com.javatribe.apilife.pojo.Activity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Cache {

    private List<Activity> activities;
    private HashMap<String, Activity> titleMap;
    private HashMap<Integer, Activity> idMap;

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void setTitleMap(HashMap<String, Activity> titleMap) {
        this.titleMap = titleMap;
    }

    public void setIdMap(HashMap<Integer, Activity> idMap) {
        this.idMap = idMap;
    }

    public List<Activity> getList() {

        return activities;
    }

    public Activity getById(int id) {
        if (idMap == null) {
            return null;
        }
        return idMap.get(id);
    }

    public Activity getByTitle(String title) {
        if (titleMap == null) {
            return null;
        }
        return titleMap.get(title);
    }
}
