package com.javatribe.apishare.service.impl;

import com.javatribe.apishare.mapper.TagMapper;
import com.javatribe.apishare.po.Tag;
import com.javatribe.apishare.service.ArtTagService;
import com.javatribe.apishare.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/14 21:03
 */

@Service
public class TagServiceImpl implements TagService {
    @Autowired(required = false)
    private TagMapper tagMapper;
    @Autowired(required = false)
    private ArtTagService artTagService;

    /**
     * 插入一个新的标签
     * 插入之前先判断一下即将插入的标签是否已经存在
     * 如果已经存在则不执行插入
     * @param tag 标签实体
     * @return 返回是否插入成功的结果，1表示成功，0表示失败, -1表示已经存在，不插入
     */
    @Override
    public int insertTag(Tag tag) {
        if (tag.getTagName() == null || "".equals(tag.equals(tag.getTagName().trim()))) {
            return 0;
        }
        int count = tagMapper.checkTag(tag.getTagName());
        if (count > 0) {
            return -1;
        }
        return tagMapper.insertTag(tag);
    }

    /**
     * 获取所有父标签
     *
     * @return
     */
    @Override
    public List<Tag> getAllParentTags() {
        return tagMapper.getAllParentTags();
    }

    /**
     * 获取指定父标签下的所有子标签
     *
     * @param tagParent 指定父标签
     * @return
     */
    @Override
    public List<Tag> getSonTags(int tagParent) {
        if (tagParent <= 0 || tagParent >= Integer.MAX_VALUE) {
            return new ArrayList<Tag>();
        }
        return tagMapper.getSonTags(tagParent);
    }

    /**
     * 根据文章id进行逻辑删除
     * 这里先做一次查询判断该标签下是否存在文章，如果有文章的话，
     * 不允许删除
     * @param tagId 文章id
     * @return
     */
    @Override
    public int deleteTagById(int tagId) {
        if (tagId <= 0 || tagId >= Integer.MAX_VALUE) {
            return 0;
        }
        int judge = artTagService.checkTag(tagId);
        return judge > 0 ? 0: tagMapper.deleteTagById(tagId);
    }

    /**
     * 修改标签的名字
     * @param tag
     * @return 0表示失败，1表示成功
     */
    @Override
    public int updateTag(Tag tag) {
        if (tag.getTagName() == null || "".equals(tag.getTagName().trim())) {
            return 0;
        }
        return tagMapper.updateTag(tag);
    }

}
