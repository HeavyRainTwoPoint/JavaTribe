package com.javatribe.apishare.po;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * art_tag
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article implements Serializable {
    private Integer artId;

    private String artTitle;

    private String artContent;

    private String artSummary;

    private Integer artViewcount;

    private String artTagName;

    private Timestamp gmtCreate;

    private Timestamp gmtModify;

    private Integer deleteStatus;

    private String artNo;

    private static final long serialVersionUID = 1L;
}