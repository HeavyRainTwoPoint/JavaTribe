package com.javatribe.direction.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.javatribe.direction.bean.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

/**
 * Cooperation实体类
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@EqualsAndHashCode(callSuper = true)
@TableName("t_cooperation")
@Data
@Builder
public class Cooperation extends BaseEntity {
    @Tolerate
    public Cooperation() {
    }

    /**
     * 合作id
     */
    @TableId(type = IdType.AUTO)
    private Integer cooperationId;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 图片链接
     */

    private String photo;

    /**
     * 内容
     */
    private String content;

    /**
     * 合作类型,0表示对内交流,1表示对外交流
     */
    private Integer type;

}
