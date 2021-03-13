package com.javatribe.cooperation.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Cooperation实体类
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Data
public class Cooperation {
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
     * 图片链接
     */
    @NotNull(message = "photo不能为空")
    private String photo;

    /**
     * 交流事项
     */
    @NotNull(message = "items不能为空")
    private String items;

    /**
     * 内容
     */
    @NotNull(message = "content不能为空")
    private String content;

    /**
     * 合作类型,0表示对内交流,1表示对外交流
     */
    @NotNull(message = "type不能为空")
    private Integer type;

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
