package com.javatribe.cooperation.bean.bo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * NewsBO,用来接收前端传来的参数
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Data
public class NewsBO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 新闻标题
     */
    @NotNull(message = "title不能为空")
    private String title;

    /**
     * 新闻图片
     */
    @NotNull(message = "photo不能为空")
    private String photo;

    /**
     * 新闻推文链接
     */
    @NotNull(message = "url不能为空")
    private String url;

    /**
     * 优先级,0表示正常排序,1表示优先级高
     */
    @NotNull(message = "type不能为空")
    private Integer priority;
}
