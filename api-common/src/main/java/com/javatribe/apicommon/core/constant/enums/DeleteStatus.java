package com.javatribe.apicommon.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 逻辑删除状态码 管理
 * @Author lyr
 * @create 2020/11/4 21:42
 */
@Getter
@AllArgsConstructor
public enum DeleteStatus {
    /**
     * 没有删除
     */
    no_deleted(0),
    /**
     * 被删除了
     */
    deleted(1);

    public int type;
}
