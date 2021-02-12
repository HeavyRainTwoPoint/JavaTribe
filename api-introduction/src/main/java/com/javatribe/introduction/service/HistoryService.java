package com.javatribe.introduction.service;

import com.javatribe.introduction.entity.History;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javatribe.introduction.entity.Management;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzp
 * @since 2021-02-12
 */
public interface HistoryService extends IService<History> {

    List<History> findAll();

    int addHistory(History history);

    int deleteHistory(Integer id);

    int updateHistory(History history);
}
