package com.javatribe.introduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javatribe.introduction.entity.History;
import com.javatribe.introduction.mapper.HistoryMapper;
import com.javatribe.introduction.service.HistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wzp
 * @date 2021/2/12 18:10
 */
@Service
@Transactional
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements HistoryService {
    @Override
    public List<History> findAll() {
        LambdaQueryWrapper<History> wrapper = new LambdaQueryWrapper<>();
        wrapper.select();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int addHistory(History history) {
        return baseMapper.insert(history);
    }

    @Override
    public int deleteHistory(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateHistory(History history) {
        return baseMapper.updateById(history);
    }
}
