package com.javatribe.apicommon.dto;

import com.github.pagehelper.IPage;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * @Author lyr
 * @create 2020/11/3 11:38
 */
public class PageParam implements IPage, Serializable {
    /**
     * 默认第一页
     */
    @Min(1)
    private Integer pageNum = 1;
    /**
     * 默认返回10条
     */
    @Max(100)
    @Min(1)
    private Integer pageSize = 10;

    /**
     * 不推荐 直接 业务层使用，容易sql注入，扩展性不高
     */
    @Null(message = "出现非法字段")
    private String orderBy;

    public static PageParam of(int pageNum,int pageSize) {
        PageParam pageParam =  new PageParam();
        pageParam.pageNum = pageNum;
        pageParam.pageSize = pageSize;
        return pageParam;
    }


    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    public PageParam setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public PageParam setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public PageParam setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }
}
