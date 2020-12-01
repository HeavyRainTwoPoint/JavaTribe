package com.javatribe.apilife.dao.impl;

import com.javatribe.apilife.dao.ActivityDao;
import com.javatribe.apilife.pojo.Activity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ActivityDaoImpl implements ActivityDao {
    private List<Activity> data;
    private Map<Integer, Activity> search;

    {
        data = new ArrayList<Activity>() {
            {
                add(new Activity(123, "部落环境", 1));
                add(new Activity(124, "部落聚餐", 2));
                add(new Activity(125, "部落福利", 3));
                add(new Activity(126, "部落很好", 4));
            }
        };
        search = new HashMap<>(data.size());
        for (Activity activity :
                data) {
            search.put(activity.getId(), activity);
        }
    }

    @Override
    public List<Activity> selectAll() {
        return new ArrayList<Activity>(){
            {
                for (Activity activity:
                     data) {
                    final Activity a = new Activity();
                    BeanUtils.copyProperties(activity, a);
                    add(a);
                }
            }
        };
    }


}
