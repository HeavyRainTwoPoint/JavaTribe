package com.javatribe.po;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * art_tag
 *
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag implements Serializable {
    private int tagId;

    private String tagName;

    private int tagParent;

    private Timestamp gmtCreate;

    private Timestamp gmtModify;

    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;
}