package com.javatribe.apienroll.service;

import com.javatribe.apicommon.dto.Response;
import com.javatribe.apienroll.entity.EnrollTest;
import com.javatribe.apienroll.entity.EnrollTestQTO;
import com.javatribe.apienroll.entity.FileManager;
import com.javatribe.apienroll.entity.FileManagerQTO;

import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/2/28 10:47
 * @description
 */
public interface FileManagerCommonService {
    // 查询列表
    Response<List<FileManager>> query(FileManagerQTO qto);
    // 添加
    Response<Integer> add(FileManager fileManager);
    // 根据主键更新
    Response<Integer> update(FileManager fileManager);
    // 根據id批量删除
    Response<Integer> delete(FileManagerQTO qto);
    // 根据主键删除
    Response<Integer> deleteById(FileManager fileManager);
}
