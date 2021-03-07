package com.javatribe.apienroll.dto;

import com.javatribe.apienroll.entity.EnrollNotice;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/7 15:48
 * @description
 */
@Data
public class EnrollNoticeDTO extends EnrollNotice implements Serializable {
    private static final long serialVersionUID = -1942736218199664303L;
    private Integer year; // 年份
}
