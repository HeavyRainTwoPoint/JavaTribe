package com.javatribe.vo;

import com.javatribe.po.Article;
import com.javatribe.po.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:29
 * 视图类，封装了文章与其标签
 */
@Data
@ToString
@Setter
@Getter
public class ArticleAndTags {
    private Article article;
    private List<Tag> tags;
}
