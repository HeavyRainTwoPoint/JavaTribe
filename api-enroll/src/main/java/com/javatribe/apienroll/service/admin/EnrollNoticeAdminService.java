package com.javatribe.apienroll.service.admin;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollNotice;
import com.javatribe.apienroll.entity.EnrollNoticeQTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:36
 * @description
 */
public interface EnrollNoticeAdminService {
    // 查询列表
    Response<List<EnrollNotice>> query(EnrollNoticeQTO qto);
    // 添加
    Response<Integer> add(EnrollNotice enrollNotice);
    // 根据主键更新
    Response<Integer> update(EnrollNotice enrollNotice);
    // 根據id批量删除
    Response<Integer> delete(EnrollNoticeQTO qto);
    // 根据主键删除
    Response<Integer> deleteById(EnrollNotice enrollNotice);
}
