package com.javatribe.apishare.cache;

import com.javatribe.apishare.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/16 21:47
 * 一个比较简陋的缓存类，替代redis来统计每一篇文章的访问数量
 * 说明：当前的情景下，引入一个redis感觉没有必要，因此自己做
 *      一个简单的缓存类来替代redis的统计
 * 相关的操作：①通过定时任务，每天晚上12点之后负责将已经统计到的数据保存回数据库中
 *           ②完成一些数据更新
 *           ③随着不断的维护，如果已经引入redis了，那么维护这一部分的师弟师妹再
 *             更换为redis缓存吧
 */

// 将该缓存纳入spring的管理当中
@Component
public final class ViewCountCache{
    /**
     * 缓存的上限
     */
    private static final int MAX_SIZE = 200;
    /**
     * 缓存的数据结构实现
     */
    private static final ConcurrentHashMap<String, Integer> VIEWCOUNT_CACHE = new ConcurrentHashMap<>(MAX_SIZE);

    @Autowired
    private static ArticleService articleService;

    /**
     * 将不在缓存中的数据放入缓存中
     * @param artNo
     */
    private static void add(String artNo) {
        if (VIEWCOUNT_CACHE.size() == MAX_SIZE) {
            clear(false);
        }
        int viewCount = articleService.getViewCountByArtNo(artNo);
        VIEWCOUNT_CACHE.put(artNo, viewCount + 1);
    }

    /**
     * 访问量+1
     * @param artNo
     */
    public static void update(String artNo){
        if (isContain(artNo)) {
            VIEWCOUNT_CACHE.put(artNo, VIEWCOUNT_CACHE.get(artNo) + 1);
        } else {
            add(artNo);
        }
    }

    /**
     * 看看将要查看的文章阅读数是不是最新的
     * @param artNo
     * @return
     */
    public static int get(String artNo) {
        if (isContain(artNo)) {
            return VIEWCOUNT_CACHE.get(artNo);
        }
        return -1;
    }

    /**
     * 判断文章是否在缓存中
     * @param artNo 文章编号
     */
    private static boolean isContain(String artNo){
        return VIEWCOUNT_CACHE.containsKey(artNo);
    }

    /**
     * 当缓存的容量已经达到上限时，随机清理掉一半数据
     * 在清理之前会先同步回数据库
     * @param cleanAll 是否全部清空？
     */
    private static void clear(boolean cleanAll){
        if (cleanAll) {
            VIEWCOUNT_CACHE.clear();
            return;
        }
        String[] tempSpace = new String[MAX_SIZE / 2];
        int index = 0;
        for (String key : VIEWCOUNT_CACHE.keySet()) {
            tempSpace[index++] = key;
        }
        for (int i = 0; i < tempSpace.length; i++) {
            record(tempSpace[i], VIEWCOUNT_CACHE.remove(tempSpace[i]));
        }
    }

    /**
     * 将数据同步回数据库中
     * @param artNo 文章编号
     * @param viewCount 阅读数量
     */
    private static void record(String artNo, int viewCount){
        articleService.updateViewCountByArtNo(artNo, viewCount);
    }

    /**
     * 重载上的记录方法，提供给定时任务调用
     */
    public static void record() {
        for (Map.Entry<String, Integer> entry : VIEWCOUNT_CACHE.entrySet()) {
            record(entry.getKey(), entry.getValue());
        }
        clear(true);
    }



}
