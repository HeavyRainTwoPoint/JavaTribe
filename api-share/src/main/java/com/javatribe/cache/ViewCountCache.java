package com.javatribe.cache;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/16 21:47
 * 一个缓存类，替代redis来统计每一篇文章的访问数量
 * 说明：当前的情景下，引入一个redis感觉没有必要，因此自己做
 *      一个简单的缓存类来替代redis的统计
 * 相关的操作：①通过定时任务，每天晚上12点之后负责将已经统计到的数据保存回数据库中
 *           ②完成一些数据更新
 *           ③随着不断的维护，如果已经引入redis了，那么维护这一部分的师弟师妹再
 *             更换为redis缓存吧
 */

//将该缓存纳入spring的管理当中
@Component
public final class ViewCountCache {
    /**
     * 缓存的上限
     */
    private static final int MAX_SIZE = 200;
    /**
     * 缓存的数据结构实现
     */
    private static final ConcurrentHashMap<String, Integer> VIEWCOUNT_CACHE = new ConcurrentHashMap<>(MAX_SIZE);

    /**
     * 将不在缓存中的数据放入缓存中
     * @param artNo
     * @param viewCount
     */
    private void add(String artNo, int viewCount) { }

    /**
     * 唯一向外部暴露的方法，访问量+1
     * @param artNo
     */
    public static void update(String artNo){
    }

    /**
     * 判断文章是否在缓存中
     * @param artNo
     */
    private static void isContain(String artNo){}

    /**
     * 当缓存的容量已经达到上限时，随机清理掉一半数据
     * 在清理之前会先同步回数据库
     */
    private static void clear(){}

    /**
     * 将数据同步回数据库中
     */
    private static void record(){}



}
