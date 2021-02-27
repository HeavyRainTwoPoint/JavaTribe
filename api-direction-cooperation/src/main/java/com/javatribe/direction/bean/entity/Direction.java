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
 * Direction实体类
 *
 * @author LCW
 * @since 2021-02-27 19:03:09
 */
@EqualsAndHashCode(callSuper = true)
@TableName("t_direction")
@Data
@Builder
public class Direction extends BaseEntity {
    @Tolerate
    public Direction() {
    }

    /**
     * 主键id
     */
    /**
     * 强制每个表都要个唯一id字段
     */
    @TableId(type = IdType.AUTO)
    private Integer directionId;

    /**
     * 方向组名
     */
    private Integer direction;

    /**
     * 方向介绍
     */
    private String content;
}
