package com.javatribe.apienroll.service.admin;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.TestNotice;
import com.javatribe.apienroll.entity.TestNoticeQTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/27 13:36
 * @description
 */
public interface TestNoticeAdminService {
    // 查询列表
    Response<List<TestNotice>> query(TestNoticeQTO qto);
    // 添加
    Response<Integer> add(TestNotice testNotice);
    // 根据主键更新
    Response<Integer> update(TestNotice testNotice);
    // 根據id批量删除
    Response<Integer> delete(TestNoticeQTO qto);
    // 根据主键删除
    Response<Integer> deleteById(TestNotice testNotice);
}
