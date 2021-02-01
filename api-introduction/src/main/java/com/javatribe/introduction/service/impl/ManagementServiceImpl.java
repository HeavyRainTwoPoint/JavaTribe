package com.javatribe.introduction.service.impl;

import com.javatribe.introduction.entity.Management;
import com.javatribe.introduction.mapper.ManagementMapper;
import com.javatribe.introduction.service.ManagementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzp
 * @since 2021-02-01
 */
@Service
public class ManagementServiceImpl extends ServiceImpl<ManagementMapper, Management> implements ManagementService {

}
