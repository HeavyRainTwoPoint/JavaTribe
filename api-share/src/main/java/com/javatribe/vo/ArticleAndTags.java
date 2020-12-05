package com.javatribe.vo;

import com.javatribe.pojo.Article;
import lombok.Data;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:29
 * 视图类，封装了文章与其标签
 */
@Data
public class ArticleAndTags {
    private Article article;
    private List<Integer> tags;
}
