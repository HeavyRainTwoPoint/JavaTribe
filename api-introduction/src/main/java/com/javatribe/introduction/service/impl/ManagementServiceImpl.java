package com.javatribe.introduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javatribe.introduction.entity.Management;
import com.javatribe.introduction.mapper.ManagementMapper;
import com.javatribe.introduction.service.ManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzp
 * @since 2021-02-01
 */
@Service
@Transactional
public class ManagementServiceImpl extends ServiceImpl<ManagementMapper, Management> implements ManagementService {

    @Override
    public List<Management> findAll() {
        LambdaQueryWrapper<Management> wrapper = new LambdaQueryWrapper<>();
        wrapper.select().orderByDesc(Management::getSessions);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Management findById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Management> findLeader() {
        LambdaQueryWrapper<Management> wrapper = new LambdaQueryWrapper<>();
        wrapper.select()
                .eq(Management::getIsLeader, 1)
                .orderByAsc(Management::getSessions);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Management> findPresent() {
        return baseMapper.presentManage();
    }

    @Override
    public int addManager(Management manage) {
        if (manage.getPosition().equals("队长")) {
            manage.setIsLeader(1);
        }
        return baseMapper.insert(manage);
    }

    @Override
    public int deleteManager(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateManager(Management manage) {
        return baseMapper.updateById(manage);
    }
}
