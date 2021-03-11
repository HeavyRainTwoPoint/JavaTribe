package com.javatribe.cooperation.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * news实体类
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Data
public class News {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 新闻标题
     */
    @NotNull(message = "title不能为空")
    private String title;

    /**
     * 新闻图片
     */
    @NotNull(message = "photo不能为空")
    private String photo;

    /**
     * 新闻推文链接
     */
    @NotNull(message = "content不能为空")
    private String url;

    /**
     * 优先级,0表示正常排序,1表示优先级高
     */
    @NotNull(message = "priority不能为空")
    private Integer priority;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建者的id
     */
    @JsonIgnore
    private Integer createBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date updateTime;

    /**
     * 更新者的id
     * 新增和更新执行
     */
    @JsonIgnore
    private Integer updateBy;
    /**
     * 虚假删除标志字段, 0为正常, 1表示已删除
     */
    @JsonIgnore
    private Integer deleteStatus;
}
