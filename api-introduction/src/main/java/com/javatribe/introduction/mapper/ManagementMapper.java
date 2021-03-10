package com.javatribe.introduction.mapper;

import com.javatribe.introduction.entity.Management;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzp
 * @since 2021-02-01
 */
public interface ManagementMapper extends BaseMapper<Management> {

    List<Management> presentManage();

}
