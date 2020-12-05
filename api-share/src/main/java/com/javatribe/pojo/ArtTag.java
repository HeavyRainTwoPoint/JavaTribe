package com.javatribe.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * art_tag
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtTag implements Serializable {
    private Integer id;

    private Integer artId;

    private Integer tagId;

    private Timestamp gmtCreate;

    private Timestamp gmtModify;

    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;
}