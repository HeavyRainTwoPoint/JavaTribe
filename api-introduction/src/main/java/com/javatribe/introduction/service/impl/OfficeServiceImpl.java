package com.javatribe.introduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javatribe.introduction.entity.Office;
import com.javatribe.introduction.mapper.OfficeMapper;
import com.javatribe.introduction.service.OfficeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzp
 * @since 2021-02-28
 */
@Service
public class OfficeServiceImpl extends ServiceImpl<OfficeMapper, Office> implements OfficeService {

    @Override
    public List<Office> findAll() {
        LambdaQueryWrapper<Office> wrapper = new LambdaQueryWrapper<>();
        wrapper.select();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int addOffice(Office office) {
        return baseMapper.insert(office);
    }

    @Override
    public int updateOffice(Office office) {
        return baseMapper.updateById(office);
    }

    @Override
    public int deleteOffice(Integer id) {
        return baseMapper.deleteById(id);
    }
}
