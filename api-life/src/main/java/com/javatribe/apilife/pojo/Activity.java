package com.javatribe.apilife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private Integer id;
    private String actTitle;
    private String actContent;
    private String actImgURL;
    private Timestamp actTime;
    private Integer priority;
    private Timestamp gmtCreate;
    private Timestamp gmtModify;
    private Integer deleteStatus;

    public Activity(int id, String actTitle, int priority) {
        this.id = id;
        this.actTitle = actTitle;
        this.priority = priority;
    }
}
