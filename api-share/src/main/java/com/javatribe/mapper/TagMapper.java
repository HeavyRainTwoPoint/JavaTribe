package com.javatribe.mapper;

import com.javatribe.po.Tag;

import java.util.List;

public interface TagMapper {
    /**
     * 插入一个新的标签
     * @param tag 标签实体，需要传递tagName，tagParent(如果tagParent==0表示该标签为一级标签）
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
     * @param tag，需要传递tagId，tagName，但是只能修改tagName
     * @return
     */
    int updateTag(Tag tag);

    /**
     * 判断即将插入的标签是否已经存在表中
     * @param tagName
     * @return 0表示失败，1表示成功
     */
    int checkTag(String tagName);
}