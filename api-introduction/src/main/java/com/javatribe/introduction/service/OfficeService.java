package com.javatribe.introduction.service;

import com.javatribe.introduction.entity.Office;
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
public interface OfficeService extends IService<Office> {

    List<Office> findAll();

    int addOffice(Office office);

    int updateOffice(Office office);

    int deleteOffice(Integer id);
}
