package com.javatribe.cooperation.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回封装类
 */
@AllArgsConstructor
@Data
public class ApiResult {
    private Integer code;
    private String msg;
    private Object data;
}
