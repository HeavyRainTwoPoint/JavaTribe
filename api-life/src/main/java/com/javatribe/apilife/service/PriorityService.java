package com.javatribe.apilife.service;

import com.javatribe.apilife.pojo.Activity;

import java.util.List;

public interface PriorityService<T> {

    List<T> getQueue();

    List<T> getQueue(Integer parentId);

    void swapPriority(int a, int b);

    void moveDown(int objectId);

    void moveUp(int objectId);
    
    void delNode(int objectId);
    
    void addNode(T t);

    int nextPriority();

    int nextPriority(int parentId);
}
