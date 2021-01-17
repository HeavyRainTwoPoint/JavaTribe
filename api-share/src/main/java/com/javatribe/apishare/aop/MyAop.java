package com.javatribe.apishare.aop;

import com.javatribe.apishare.cache.ViewCountCache;
import com.javatribe.apishare.po.Article;
import com.javatribe.apishare.vo.ArticleAndTags;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2021/1/17 16:47
 * 切面类，做一些数据修改
 */
@Aspect
@Component
public class MyAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 切点方法，定义切点
     */
    @Pointcut("execution(public com.javatribe.apishare.vo.ArticleAndTags selectOneByArtNo(..))")
    private void declarePointcut(){}

    /**
     * 通过AfterReturning通知来查看目标文章的阅读数
     * 是不是最新的，如果不是则用缓存中的数据替换
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "declarePointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        Article article = ((ArticleAndTags)result).getArticle();
        int viewCount = ViewCountCache.get(article.getArtNo());
        if (viewCount > article.getArtViewcount()) {
            article.setArtViewcount(viewCount);
        }
    }

}
