package com.javatribe.apienroll.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 10:47
 * @description
 */
public interface EnrollTestAdminService {
    // 查询列表
    Response<List<EnrollTest>> query(EnrollTestQTO qto);
    // 添加
    Response<Integer> add(EnrollTest enrollTest);
    // 根据主键更新
    Response<Integer> update(EnrollTest enrollTest);
    // 根據id批量删除
    Response<Integer> delete(EnrollTestQTO qto);
    // 根据主键删除
    Response<Integer> deleteById(EnrollTest enrollTest);
}
