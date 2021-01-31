package com.javatribe.apicompetition.service.impl;

import com.javatribe.apicompetition.mapper.StyleShowMapper;
import com.javatribe.apicompetition.mapper.StyleShowMapperCustom;
import com.javatribe.apicompetition.pojo.po.StyleShow;
import com.javatribe.apicompetition.service.TribeStyleShowService;
import com.javatribe.apicompetition.util.InsertUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部落风采模块
 * @Author lyr
 * @create 2021/1/16 15:49
 */
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TribeStyleShowServiceImpl implements TribeStyleShowService {
    final StyleShowMapper styleShowMapper;
    final StyleShowMapperCustom styleShowMapperCustom;


    /**
     * @return 获取风采暂时
     */
    @Override
    public List<StyleShow> getAllStyleShow() {
        return styleShowMapperCustom.getFirstPage()
                ;

    }


    /**
     * 更新风采展示
     *
     * @param styleShow
     * @return
     */
    @Override
    public int updateById(StyleShow styleShow) {
        return styleShowMapper.updateByPrimaryKey(styleShow);
    }

    @Override
    public void insertOne(StyleShow styleShow) {
        InsertUtil.setDefaultValue(styleShow);
        styleShowMapper.insert(styleShow);

    }

    /**
     * 逻辑删除  根据 ID
     *
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        StyleShow record = styleShowMapper.selectByPrimaryKey(id);
        //设置逻辑删除
        record.setDeleteStatus(true);
        //更新回 数据库
        styleShowMapper.updateByPrimaryKey(record);
    }
}
