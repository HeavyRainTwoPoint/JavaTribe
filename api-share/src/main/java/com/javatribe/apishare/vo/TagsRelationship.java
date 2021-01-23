package com.javatribe.apishare.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:33
 * 视图类，封装了父标签与去子标签（们）
 */
@Data
@AllArgsConstructor
@Getter
@Setter
public class TagsRelationship {
    /**
     * 文章ID
     */
    private int artId;
    /**
     * 标签ID集
     */
    private List<Integer> tagIds;
}
