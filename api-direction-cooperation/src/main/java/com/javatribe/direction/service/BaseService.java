package com.javatribe.direction.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javatribe.direction.bean.BaseEntity;
import com.javatribe.direction.bean.dto.PageParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline;

/**
 * 基础的service
 * 封装了基本的增删改查和分页查询
 */
@Slf4j
public abstract class BaseService<T extends BaseEntity, M extends BaseMapper<T>> {

    @Autowired
    protected M mapper;

    /**
     * 添加实体
     */
    public T insert(T record) {
        record.setCreateTime(new Date());
        int i = mapper.insert(record);
        return i > 0 ? record : null;
    }

    @Transactional
    public void batchInsert(List<T> records) {
        for (T record : records) {
            record.setCreateTime(new Date());
            mapper.insert(record);
        }
    }

    /**
     * 根据id获取实体
     *
     * @param id 主键
     * @return 实体对象
     */
    public T get(Serializable id) {
        return mapper.selectById(id);
    }

    /**
     * 根据id获取实体
     *
     * @param id 主键
     * @return 实体对象
     */
    public T getById(Serializable id) {
        return mapper.selectById(id);
    }

    /**
     * 条件查询
     *
     * @param and 相等条件
     * @return 实体列表
     */
    public T getOne(T and) {
        return mapper.selectOne(new QueryWrapper<T>().setEntity(and).last("limit 1"));
    }

    /**
     * 条件查询
     *
     * @param and 相等条件
     * @return 实体列表
     */
    public List<T> get(T and) {
        return mapper.selectList(new QueryWrapper<T>().setEntity(and));
    }

    /**
     * 根据id删除实体
     *
     * @param id 主键
     */
    public void delete(Serializable id) {
        mapper.deleteById(id);
    }

    /**
     * 根据id集批量删除实体
     *
     * @param ids id集
     */
    @Transactional
    public void delete(List<Serializable> ids) {
        mapper.deleteBatchIds(ids);
    }

    /**
     * 查询所有
     *
     * @return 实体列表
     */
    public List<T> queryAll() {
        return mapper.selectList(null);
    }

    /**
     * 条件查询所有
     *
     * @return 实体列表
     */
    public List<T> queryAll(T and, T like) {
        return mapper.selectList(getLikeWrapper(like).setEntity(and));
    }

    /**
     * 根据id更新实体
     *
     * @param record 必须要有id字段
     * @return 失败返回null
     */
    public T update(T record) {
        record.setUpdateTime(new Date());
        mapper.updateById(record);
        return record;
    }

    /**
     * 全部删除
     */
    public void clear() {
        mapper.delete(null);
    }


    public Page<T> getPage(Integer page, Integer limit) {
        return getPage(null, null, page, limit);
    }

    public Page<T> getPage(T and, T like, Integer page, Integer limit) {
        return getPage(and, like, null, null, page, limit);
    }

    public Page<T> getPage(T and, T like, Date startTime, Date endTime, Integer page, Integer limit) {

        QueryWrapper<T> wrapper = new QueryWrapper<T>()
                .setEntity(and)
                .ge(startTime != null, "create_time", startTime)
                .le(endTime != null, "create_time", endTime);

        return mapper.selectPage(new Page<>(page, limit), wrapper);
    }


    protected QueryWrapper<T> getLikeWrapper(T like) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        if (like != null) {
            //反射获取属性
            Field[] fields = like.getClass().getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object val = field.get(like);
                    String column;
                    if (val != null && !"".equals(val.toString())) {
                        TableField tableField = field.getAnnotation(TableField.class);
                        // 没有注解，取默认为下划线拼接
                        if (tableField == null) {
                            column = camelToUnderline(field.getName());
                        } else {
                            // 排除非数据库字段
                            if (tableField.exist()) {
                                continue;
                            } else {
                                //没有定义查询属性，取默认
                                column = field.getName();
                            }
                        }
                        wrapper.like(column, val);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return wrapper;
    }

}

