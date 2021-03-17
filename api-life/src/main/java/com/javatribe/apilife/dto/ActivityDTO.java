package com.javatribe.apilife.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ActivityDTO {

    private Integer id;
    private String actTitle;
    private String actContent;
    private String[] imgs;

}
