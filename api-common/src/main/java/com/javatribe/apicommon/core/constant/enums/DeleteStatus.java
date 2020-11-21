package com.javatribe.apicommon.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author lyr
 * @create 2020/11/4 21:42
 */
@Getter
@AllArgsConstructor
public enum DeleteStatus {
    no_deleted(0),
    deleted(1);

    public int type;
}
