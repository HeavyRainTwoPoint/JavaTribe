package com.javatribe.introduction.service;

import com.javatribe.introduction.entity.Postgraduate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzp
 * @since 2021-02-28
 */
public interface PostgraduateService extends IService<Postgraduate> {

    List<Postgraduate> findAll();

    int addPostGraduate(Postgraduate postgraduate);

    int updatePostGraduate(Postgraduate postgraduate);

    int deletePostGraduate(Integer id);
}
