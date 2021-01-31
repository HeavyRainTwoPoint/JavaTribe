package com.javatribe.apicompetition.mapper;

import com.javatribe.apicompetition.pojo.po.StyleShow;

import java.util.List;

/**
 * @Author lyr
 * @create 2021/1/31 23:27
 */
public interface StyleShowMapperCustom {
    /**
     * @return 获取首页风采展示数据
     */
    List<StyleShow> getFirstPage();
}
