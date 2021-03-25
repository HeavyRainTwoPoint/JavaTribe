package com.javatribe.apishare.service;

import com.javatribe.apishare.po.Tag;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/12/5 13:52
 */

public interface TagService {
    /**
     * 插入一个新的标签
     * @param tag 标签实体 需要包含tagName， tagParent两个值，传递0表示作为一级标签
     * @return 返回是否插入成功的结果，1表示成功，0表示失败
     */
    int insertTag(Tag tag);

    /**
     * 获取所有父标签
     * @return
     */
    List<Tag> getAllParentTags();

    /**
     * 获取指定父标签下的所有子标签
     * @param tagParent 指定父标签
     * @return
     */
    List<Tag> getSonTags(int tagParent);

    /**
     * 根据文章id进行逻辑删除
     * @param tagId 文章id
     * @return
     */
    int deleteTagById(int tagId);

    /**
     * 修改标签的名字
     * @param tag 需要传递tagName，tagId两个值
     * @return 0表示失败，1表示成功
     */
    int updateTag(Tag tag);

    /**
     * 根据标签id获取标签名
     * @param tagId
     * @return
     */
    String getTagNameById(int tagId);

}
