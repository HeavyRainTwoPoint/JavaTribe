package com.javatribe.po;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.*;

/**
 * art_tag
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtTag implements Serializable {
    private Integer id;

    private Integer artId;

    private Integer tagId;

    private Timestamp gmtCreate;

    private Timestamp gmtModify;

    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;
}