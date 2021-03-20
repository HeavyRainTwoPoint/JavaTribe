package com.javatribe.apilife.service.impl;

import com.javatribe.apilife.cache.Cache;
import com.javatribe.apilife.dao.ActivityDao;
import com.javatribe.apilife.dto.ActivityDTO;
import com.javatribe.apilife.expt.SqlException;
import com.javatribe.apilife.expt.SwapException;
import com.javatribe.apilife.pojo.Activity;
import com.javatribe.apilife.service.LifeInfoManipulation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public class LifeInfoManipulationServiceImpl implements LifeInfoManipulation {

    @Autowired
    ActivityDao activityDao;
    @Autowired
    Cache cache;

    @Override
    public void insertActivity(ActivityDTO dto) throws SqlException {
        if (StringUtils.isEmpty(dto.getActTitle())
                || StringUtils.isEmpty(dto.getActContent()) || dto.getImgs() == null
                || dto.getImgs().length == 0) {
            throw new SqlException("信息不全");
        }
        boolean isExist = activityDao.isExistTitle(dto.getActTitle()) == 1;
        if (isExist) {
            throw new SqlException("标题存在");
        }
        final Timestamp now = new Timestamp(System.currentTimeMillis());
        Activity activity = new Activity();
        BeanUtils.copyProperties(dto, activity);
        activity.setActImgURL(join(dto.getImgs(), ","));
        activity.setPriority(activityDao.latestPriority() + 1);
        activity.setActTime(now);
        activity.setGmtCreate(now);
        activity.setGmtModify(now);
        activity.setDeleteStatus(0);
        activityDao.insert(activity);
        afreshCache();
    }

    @Override
    public void updateActivityById(ActivityDTO dto) throws SqlException {
        if (dto.getId() == null) {
            throw new SqlException("需要id参数");
        }
        boolean isExist = activityDao.isExistId(dto.getId()) == 1;
        if (!isExist) {
            throw new SqlException("id不存在");
        }
        Activity activity = new Activity();
        BeanUtils.copyProperties(dto, activity);
        activity.setActImgURL(join(dto.getImgs(), ","));
        activity.setGmtModify(new Timestamp(System.currentTimeMillis()));
        activityDao.updateById(activity);
        afreshCache();
    }

    @Override
    public void updateActivityByTitle(ActivityDTO dto) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(dto, activity);
        activity.setActImgURL(join(dto.getImgs(), ","));
        activity.setGmtModify(new Timestamp(System.currentTimeMillis()));
        activityDao.updateByTitle(activity);
        afreshCache();
    }

    @Override
    public void deleteActivityById(int id) {
        activityDao.deleteById(id);
        afreshCache();
    }

    @Override
    public void deleteActivityByTitle(String title) {
        int id = activityDao.selectIdByTitle(title);
        deleteActivityById(id);
    }

    @Override
    public void priorityMoveUp(int id) {
        int priority = activityDao.selectPriorityById(id);
        Integer upId = activityDao.selectUpIdByPriority(priority);
        if (upId == null) {
            throw new SwapException("优先级为极值");
        }
        final int upPriority = activityDao.selectPriorityById(upId);
        activityDao.updatePriorityById(id, upPriority);
        activityDao.updatePriorityById(upId, priority);
        afreshCache();
    }

    @Override
    public void priorityMoveDown(int id) {
        int priority = activityDao.selectPriorityById(id);
        Integer downId = activityDao.selectDownIdByPriority(priority);
        if (downId == null) {
            throw new SwapException("优先级为极值");
        }
        final int upPriority = activityDao.selectPriorityById(downId);
        activityDao.updatePriorityById(id, upPriority);
        activityDao.updatePriorityById(downId, priority);
        afreshCache();
    }

    @Override
    public void prioritySwap(int a, int b) {
        final int aP = activityDao.selectPriorityById(a);
        final int bP = activityDao.selectPriorityById(b);
        activityDao.updatePriorityById(a, bP);
        activityDao.updatePriorityById(b, aP);
        afreshCache();
    }

    private void afreshCache() {
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

    private String join(String[] strings, String join) {
        if (strings == null) {
            return null;
        } else if (strings.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++) {
            sb.append(strings[i].trim());
            sb.append(join);
        }
        sb.append(strings[strings.length - 1]);
        return sb.toString();
    }
}
