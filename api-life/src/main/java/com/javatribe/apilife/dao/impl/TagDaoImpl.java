package com.javatribe.apilife.dao.impl;

import com.javatribe.apilife.dao.TagDao;
import com.javatribe.apilife.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TagDaoImpl implements TagDao {

    private List<Tag> data;
    private Map<Integer, Tag> search;

    {
        data = new ArrayList<Tag>() {
            {
                add(new Tag(1, 0, 1, "1"));
                add(new Tag(2, 0, 2, "2"));
                add(new Tag(3, 0, 3, "3"));
                add(new Tag(4, 0, 4, "4"));
                add(new Tag(5, 1, 1, "A"));
                add(new Tag(6, 1, 2, "B"));
                add(new Tag(7, 1, 3, "C"));
                add(new Tag(8, 2, 1, "I"));
                add(new Tag(9, 2, 2, "II"));
                add(new Tag(10, 2, 3, "III"));
            }
        };
        search = new HashMap<>(data.size());
        for (Tag tag :
                data) {
            search.put(tag.getId(), tag);
        }
    }

    @Override
    public List<Tag> selectAll() {
        return new ArrayList<Tag>(){
            {
                for (Tag tag:
                        data) {
                    final Tag a = new Tag();
                    BeanUtils.copyProperties(tag, a);
                    add(a);
                }
            }
        };
    }
}
