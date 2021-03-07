package com.javatribe.apienroll.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollDirection;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/1 22:03
 * @description
 */
public interface EnrollDirectionService {
    Response<List<EnrollDirection>> getLastNItemsOnPerDirection(Integer n);
}
