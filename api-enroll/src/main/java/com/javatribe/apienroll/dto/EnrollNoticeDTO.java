package com.javatribe.apienroll.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/2 22:15
 * @description
 */
@Data
public class EnrollNoticeDTO implements Serializable {
    private static final long serialVersionUID = -1942736218199664303L;

    private String title; // 考核通知名称（前端第一次考核）

    private Integer directionCode; // 方向代号

    private List<String> docxUrls;

    private String contentFileUrl;
}
