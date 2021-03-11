package com.javatribe.cooperation.service;

import com.javatribe.cooperation.bean.entity.Cooperation;
import com.javatribe.cooperation.mapper.CooperationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CooperationService {

    @Resource
    private CooperationMapper cooperationMapper;

    public void insert(Cooperation record) {
        cooperationMapper.insert(record);
    }

    public Cooperation get(Integer id) {
        return cooperationMapper.selectById(id);
    }

    public void update(Cooperation old) {
        old.setUpdateTime(new Date());
        cooperationMapper.update(old);
    }

    public void delete(Integer id) {
        cooperationMapper.delete(id);
    }

    public List<Cooperation> getAll(Integer type) {
        return cooperationMapper.getAll(type);
    }

    public List<Cooperation> page(Integer page, Integer type) {
        return cooperationMapper.getByPages(page * 3, 3, type);
    }

    public Integer getCounts() {
        return cooperationMapper.getCounts();
    }
}