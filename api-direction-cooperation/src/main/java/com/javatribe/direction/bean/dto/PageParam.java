package com.javatribe.direction.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Date;

/**
 * 分页参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam<T> {
    /**
     * 当前页
     */
    @Min(1)
    @NonNull
    Integer page;
    /**
     * 每页大小
     */
    @Min(1)
    @NotNull
    Integer limit;
    /**
     * 开始时间条件
     */
    String startTime;
    /**
     * 结束时间条件
     */
    String endTime;
    /**
     * 排序字段
     */
    String sortFieldName;
    /**
     * 升序还是降序
     */
    Boolean desc;

    /**
     * 查询条件
     */
    T andQuery;

    /**
     * 查询条件
     */
    T likeQuery;

    /**
     * 获取开始时间date对象
     */
    public Date getStartDate() {
        if (StringUtils.isNotBlank(startTime)) {
            try {
                return DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取开始时间date对象
     *
     * @param pattern 时间格式
     */
    public Date getStartDate(String pattern) {
        if (StringUtils.isNotBlank(startTime)) {
            try {
                return DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 获取结束时间date对象
     */
    public Date getEndDate() {
        if (StringUtils.isNotBlank(endTime)) {
            try {
                return DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 获取结束时间date对象
     *
     * @param pattern 时间格式
     */
    public Date getEndDate(String pattern) {
        if (StringUtils.isNotBlank(endTime)) {
            try {
                return DateUtils.parseDate(endTime, pattern);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}