package com.javatribe.introduction.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wzp
 * @date 2020/11/22 19:59
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    // mp高版本
//    @Override
//    public void insertFill(MetaObject metaObject) {
//        log.info("insert fill...");
//        // 属性名称，不是字段名称
//        this.strictInsertFill(metaObject, "gmtCreate", LocalDateTime.class, LocalDateTime.now());
//        this.strictInsertFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
//    }
//
//    @Override
//    public void updateFill(MetaObject metaObject) {
//        log.info("update fill...");
//        this.strictUpdateFill(metaObject, "gmtModified", LocalDateTime.class, LocalDateTime.now());
//    }

    // mp低版本
    @Override
    public void insertFill(MetaObject metaObject) {
        //插入时的填充策略
        log.info("start insert fill ....");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
