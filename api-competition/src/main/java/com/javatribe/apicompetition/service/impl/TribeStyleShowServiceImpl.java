package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.StyleShowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部落风采模块
 * @Author lyr
 * @create 2021/1/16 15:49
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TribeStyleShowServiceImpl {
    final StyleShowMapper styleShowMapper;



}
