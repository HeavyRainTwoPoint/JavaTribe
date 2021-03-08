package com.javatribe.apienroll.dto;

import com.javatribe.apienroll.entity.TestNotice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Liang.Yong.hui
 * @date 2021/3/7 16:24
 * @description
 */
@Data
public class TestNoticeDTO extends TestNotice implements Serializable {
    private static final long serialVersionUID = 630973080815620028L;
    private List<String> noticeFileList; // 链接列表
}
