package com.javatribe.introduction.service;

import com.javatribe.introduction.entity.Management;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzp
 * @since 2021-02-01
 */
public interface ManagementService extends IService<Management> {

    List<Management> findAll();

    Management findById(String id);

    List<Management> findLeader();

    List<Management> findPresent();

    int addManager(Management manage);

    int deleteManager(Integer id);

    int updateManager(Management manage);
}
