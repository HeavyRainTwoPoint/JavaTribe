package com.javatribe.apicompetition.service;

import com.javatribe.apicompetition.pojo.po.StyleShow;

import java.util.List;

/**
 * 部落风采
 * @Author lyr
 * @create 2021/1/16 15:49
 */
public interface TribeStyleShowService {

    /**
     * @return 部落官网首页获取风采展示
     */
    List<StyleShow> getAllStyleShow();

    /**
     * 更新风采展示
     * @param styleShow
     * @return
     */
    int updateById(StyleShow styleShow);


    /**
     * @param styleShow 插入一条数据，风采展示
     */
    void insertOne(StyleShow styleShow);


    /**
     * 逻辑删除  根据 ID
     * @param id
     */
    void deleteById(Long id);

}
