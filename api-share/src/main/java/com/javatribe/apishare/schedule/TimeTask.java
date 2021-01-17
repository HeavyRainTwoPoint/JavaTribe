package com.javatribe.apishare.schedule;

import com.javatribe.apishare.cache.ViewCountCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/17 16:00
 * 定时任务类
 */

@Component
public class TimeTask {
    private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);

    /**
     * 定时将缓存的数据保存到数据库中
     */
    @Scheduled(cron = "00 00 00 * * ?")
    public void updateTask() {
        logger.info("定时任务正常启动...");
        ViewCountCache.record();
    }
}
