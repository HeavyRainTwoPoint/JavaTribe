package com.javatribe.apienroll.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollDirection;
import com.javatribe.apienroll.entity.EnrollDirectionQTO;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 22:05
 * @description
 */
public interface EnrollDirectionService {
    // 查询列表
    Response<List<EnrollDirection>> query(EnrollDirectionQTO qto);
    // 添加
    Response<Integer> add(EnrollDirection enrollDirection);
}
