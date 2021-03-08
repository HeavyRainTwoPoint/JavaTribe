package com.javatribe.introduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javatribe.introduction.entity.Postgraduate;
import com.javatribe.introduction.mapper.PostgraduateMapper;
import com.javatribe.introduction.service.PostgraduateService;
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
public class PostgraduateServiceImpl extends ServiceImpl<PostgraduateMapper, Postgraduate> implements PostgraduateService {

    @Override
    public List<Postgraduate> findAll() {
        LambdaQueryWrapper<Postgraduate> wrapper = new LambdaQueryWrapper<>();
        wrapper.select();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public int addPostGraduate(Postgraduate postgraduate) {
        return baseMapper.insert(postgraduate);
    }

    @Override
    public int updatePostGraduate(Postgraduate postgraduate) {
        return baseMapper.updateById(postgraduate);
    }

    @Override
    public int deletePostGraduate(Integer id) {
        return baseMapper.deleteById(id);
    }
}
