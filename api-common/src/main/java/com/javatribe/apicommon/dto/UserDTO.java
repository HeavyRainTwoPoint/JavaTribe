package com.javatribe.apicommon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/16 21:03
 * @description
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2267905212719785614L;
    private String schoolNumber; // 学号
    @JsonProperty("userrealname")
    private String userRealName;  // 真实姓名
    private String token; // token
    private Integer status;
}
