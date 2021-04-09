package com.javatribe.apienroll.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Liang.Yong.hui
 * @date 2021/4/8 22:28
 * @description
 */
@Data
public class FileDataDTO implements Serializable {
    private static final long serialVersionUID = -1942736218199123303L;

    private Long id;

    private String fileName;

    private String fileUrl;

}
