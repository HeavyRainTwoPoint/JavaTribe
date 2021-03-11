package com.javatribe.cooperation.bean.bo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * CooperationBO,用来接收前端传来的参数
 *
 * @author LCW
 * @since 2021-02-27 20:20:52
 */
@Data
public class CooperationBO {
    /**
     * 强制每个表都要个唯一id字段
     */
    private Integer id;

    /**
     * 新闻标题
     */
    @NotNull(message = "title不能为空")
    private String title;

    /**
     * 图片链接
     */
    @NotNull(message = "photo不能为空")
    private String photo;

    /**
     * 内容
     */
    @NotNull(message = "content不能为空")
    private String content;

    /**
     * 合作类型,0表示对内交流,1表示对外交流
     */
    @NotNull(message = "type不能为空")
    private Integer type;
}
