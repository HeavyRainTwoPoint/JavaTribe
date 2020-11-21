package com.javatribe.apicommon.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * 查询对象封装
 *
 * @Author lyr
 * @create 2020/10/25 15:24
 */
@Data
@Accessors(chain = true)
public class QueryInfo<T extends IQuery> {

    /**
     * 分页查询
     */
    PageParam pageParam;
    /**
     * 分页查询对象
     */
    T queryObject;

    public static <T extends IQuery> QueryInfo<T> of(@NonNull PageParam pageParam,
                                                     @NonNull T queryObject) {
        return new QueryInfo<T>().setPageParam(pageParam).setQueryObject(queryObject);
    }

    public static <T extends IQuery> QueryInfo<T> ofNullable(int page,int size,
                                                      T queryObject) {
        return new QueryInfo<T>().setPageParam(PageParam.of(page,size)).setQueryObject(queryObject);
    }
    public static <T extends IQuery> QueryInfo<T> of(int limit,
                                                     @NonNull T queryObject) {
        return new QueryInfo<T>().setPageParam(PageParam.of(1,limit)).setQueryObject(queryObject);
    }

}
