package com.javatribe.apicommon.dto;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * 将 pageInfo 转 pageEntity
 * @Author lyr
 * @create 2020/10/11 16:06
 */
@Data
public class PageEntity<T> extends BaseEntity<T>{
    public static <T> PageEntity<T> of(@NonNull PageInfo<T> pageInfo) {
        PageEntity<T> entity = new PageEntity<>();
        entity.list = pageInfo.getList();
        entity.total = pageInfo.getTotal();
        entity.size = pageInfo.getPageSize();
        entity.curPage = pageInfo.getPageNum();
        entity.pages = pageInfo.getPages();

        return entity;
    }

    public static <T> PageEntity<T> of(@NonNull List<T> pageInfo) {
        return of(new PageInfo<>(pageInfo));
    }


    /**
     * 分页封装
     * @param pageParam
     * @param iSelect
     * @param <T>
     * @return
     */
    public static <T> PageEntity<T> wrap(PageParam pageParam, ISelect iSelect) {
        PageInfo<T> pageInfo = PageHelper.startPage(pageParam).doSelectPageInfo(iSelect);
        return of(pageInfo);
    }

    private List<T> list;
    /**
     * 当前页
     */
    private int curPage;
    /**
     * 返回数
     */
    private int size;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;


}
