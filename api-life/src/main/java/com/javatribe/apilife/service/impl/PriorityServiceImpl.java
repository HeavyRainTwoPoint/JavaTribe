package com.javatribe.apilife.service.impl;

import com.javatribe.apilife.service.PriorityService;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对象排序
 * ！线程不安全
 * <p>
 * 数据结构：map + 链表
 * <p>
 *
 * @author yitao.wu
 */
public class PriorityServiceImpl<T> implements PriorityService<T> {

    private Method idGet;
    private Method idSet;
    private Method priorityGet;
    private Method prioritySet;
    private Method parentGet;
    private Method parentSet;
    /**
     * 顶级类别
     */
    private final static int TOP = 0;

    public PriorityServiceImpl(List<T> initialData, Class<T> clazz, String idAttr, String priorityAttr) {
        this(initialData, clazz, idAttr, priorityAttr, null);
    }

    public PriorityServiceImpl(List<T> initialData, Class<T> clazz, String idAttr, String priorityAttr, String parentAttr) {
        try {
            idAttr = idAttr.substring(0, 1).toUpperCase() + idAttr.substring(1);
            priorityAttr = priorityAttr.substring(0, 1).toUpperCase() + priorityAttr.substring(1);
            idGet = clazz.getDeclaredMethod("get" + idAttr);
            idSet = clazz.getDeclaredMethod("set" + idAttr, Integer.class);
            priorityGet = clazz.getDeclaredMethod("get" + priorityAttr);
            prioritySet = clazz.getDeclaredMethod("set" + priorityAttr, Integer.class);
            idGet.setAccessible(true);
            idSet.setAccessible(true);
            priorityGet.setAccessible(true);
            prioritySet.setAccessible(true);
            if (parentAttr != null) {
                parentAttr = parentAttr.substring(0, 1).toUpperCase() + parentAttr.substring(1);
                parentGet = clazz.getDeclaredMethod("get" + parentAttr);
                parentSet = clazz.getDeclaredMethod("set" + parentAttr, Integer.class);
                parentGet.setAccessible(true);
                parentSet.setAccessible(true);
            }
            initial(initialData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("反射失败", e);
        }
    }

    /**
     * 数据结构：
     * header -> 1 -> 2 -> 3 -> 4
     * |         |    |
     * |         |    header -> A -> B -> C
     * |         header -> a -> b -> c
     * header -> I -> II -> III
     */
    private Node<T> header;
    private HashMap<Integer, Node<T>> map;
    private HashMap<Integer, List<T>> queues;

    private void initial(List<T> initialData) throws InvocationTargetException, IllegalAccessException {
        header = new Node<>(null);
        map = new HashMap<>(10);
        queues = setQueue(initialData);
    }

    @SneakyThrows
    private HashMap<Integer, List<T>> setQueue(List<T> initialData) {
        HashMap<Integer, List<T>> temp = new HashMap<>(1);
        if (parentGet != null) {
            for (T t :
                    initialData) {
                if ((Integer) parentGet.invoke(t) == TOP) {
                    final Node<T> h = insertNode(header, t);
                    h.down = new Node<>(null);
                }
            }
            updateObjectsList(temp, header);
            for (T t :
                    initialData) {
                int parentId = (Integer) parentGet.invoke(t);
                if (parentId != TOP) {
                    final Node<T> h = map.get(parentId).down;
                    insertNode(h, t);
                }
            }
            for (T t :
                    temp.get(TOP)) {
                final Integer id = (Integer) idGet.invoke(t);
                final Node<T> node = map.get(id);
                updateObjectsList(temp, node.down, id);
            }
        } else {
            for (T t :
                    initialData) {
                insertNode(header, t);
            }
            updateObjectsList(temp, header);
        }
        return temp;
    }

    private Node<T> insertNode(Node<T> header, T t) throws InvocationTargetException, IllegalAccessException {
        Node<T> node = new Node<T>(t);
        map.put((Integer) idGet.invoke(t), node);
        if (header.next == null) {
            header.next = node;
            node.pre = header;
        } else {
            int priority = (Integer) priorityGet.invoke(t);
            Node<T> temp = header.next;
            int curPriority;
            while (temp.next != null) {
                curPriority = (Integer) priorityGet.invoke(temp.object);
                if (curPriority > priority) {
                    node.pre = temp.pre;
                    node.next = temp;
                    temp.pre = node;
                    node.pre.next = node;
                    return node;
                }
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;
        }
        return node;
    }

    @Override
    public List<T> getQueue() {
        return queues.get(TOP);
    }

    @SneakyThrows
    @Override
    public HashMap<Integer, List<T>> afreshQueue(List<T> list) {
        initial(list);
        return queues;
    }

    @Override
    public List<T> getQueue(Integer parentId) {
        return queues.get(parentId);
    }

    @Override
    public HashMap<Integer, List<T>> getAllQueue() {
        return queues;
    }

    /**
     * 预防两个人以上操作
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 1、数据存储 （事务开启）
     * 2、队列节点交换
     * 3、 更新列表
     *
     * @param a a
     * @param b b
     */
    @Override
    public void swapPriority(int a, int b) {
        if (!checkId(a) || !checkId(b)) {
            throw new RuntimeException("非法id参数");
        }
        Integer parentId = TOP;
        Node<T> node = header;
        if (parentGet != null) {
            parentId = checkClass(a, b);
            if (parentId != TOP) {
                node = map.get(parentId).down;
            }
        }
        final Node<T> x = map.get(a);
        final Node<T> y = map.get(b);
        prioritySwap(x.object, y.object);
        swapNode(x, y);
        updateObjectsList(node, parentId);
    }

    @SneakyThrows
    private void prioritySwap(T a, T b) {
        int temp = (int) priorityGet.invoke(a);
        prioritySet.invoke(a, priorityGet.invoke(b));
        prioritySet.invoke(b, temp);
    }

    private void swapNode(Node<T> x, Node<T> y) {
        final Node<T> preX = x.pre;
        final Node<T> nextX = x.next;
        if (preX == y) {
            if (y.pre != null) {
                y.pre.next = x;
            }
            x.pre = y.pre;
            x.next = y;
            y.pre = x;
            y.next = nextX;
            if (nextX != null) {
                nextX.pre = y;
            }
        } else if (nextX == y) {
            if (y.next != null) {
                y.next.pre = x;
            }
            x.pre = y;
            x.next = y.next;
            y.pre = preX;
            y.next = x;
            if (preX != null) {
                preX.next = y;
            }
        } else {
            if (y.pre != null) {
                y.pre.next = x;
            }
            if (y.next != null) {
                y.next.pre = x;
            }
            x.pre = y.pre;
            x.next = y.next;
            if (preX != null) {
                preX.next = y;
            }
            if (nextX != null) {
                nextX.pre = y;
            }
            y.pre = preX;
            y.next = nextX;
        }
    }

    @SneakyThrows
    private Integer checkClass(int a, int b) {
        int aa = (Integer) parentGet.invoke(map.get(a).object);
        int bb = (Integer) parentGet.invoke(map.get(b).object);

        if (aa != bb) {
            throw new RuntimeException("不属于同类别");
        }
        return aa;
    }

    @Override
    public void moveDown(int objectId) {
        if (!checkId(objectId)) {
            throw new RuntimeException("非法id参数");
        }
        final int next = afterPriorityId(objectId);
        swapPriority(objectId, next);
    }

    @Override
    public void moveUp(int objectId) {
        if (!checkId(objectId)) {
            throw new RuntimeException("非法id参数");
        }
        final int pre = prePriorityId(objectId);
        swapPriority(objectId, pre);
    }

    private boolean checkId(int objectId) {
        return map.containsKey(objectId);
    }

    @Override
    public void delNode(int objectId) {
        if (parentGet != null && checkChildren(objectId)) {
            throw new RuntimeException("有子节点");
        }
        final Node<T> node = map.get(objectId);
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        node.pre = null;
        node.next = null;
        final Node<T> n = map.remove(objectId);
        updateObjectsList(findQueueHeader(n.object));
        queues.remove(objectId);
    }

    @SneakyThrows
    private boolean checkChildren(int objectId) {
        Node<T> h = map.get(objectId).down;
        return h != null && h.next != null;
    }

    /**
     * 添加节点
     * 1、找到所属队列
     * 2、队列最后添加
     *
     * @param t 待添加节点
     */
    @Override
    public void addNode(T t) {
        try {
            Node<T> h = findQueueHeader(t);
            Node<T> temp = h;
            Node<T> node = new Node<>(t);
            map.put((Integer) idGet.invoke(t), node);
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.pre = temp;
            if (parentGet != null) {
                if (h == header) {
                    queues.put((Integer) idGet.invoke(t), new ArrayList<T>());
                }
                updateObjectsList(h, (Integer) parentGet.invoke(t));
            } else {
                updateObjectsList(h);
            }
        } catch (Exception e) {
            throw new RuntimeException("反射出错", e);
        }

    }

    @Override
    public int nextPriority() {
        return nextPriority(TOP);
    }

    /**
     * 该类别下一个优先级
     *
     * @param parentId 所属类别
     * @return 该类别下一个优先级
     */
    @Override
    public int nextPriority(int parentId) {
        Node<T> h = parentId == TOP ? header : map.get(parentId).down;
        Node<T> node = h;
        while (node.next != null) {
            node = node.next;
        }
        try {
            return h == node ? 1 : (Integer) priorityGet.invoke(node.object) + 1;
        } catch (Exception e) {
            throw new RuntimeException("反射失败", e);
        }
    }

    private void updateObjectsList(Node<T> header) {
        updateObjectsList(header, TOP);
    }

    private void updateObjectsList(Map<Integer, List<T>> queues, Node<T> header) {
        updateObjectsList(queues, header, TOP);
    }

    private void updateObjectsList(Node<T> header, Integer parentId) {
        updateObjectsList(queues, header, parentId);
    }

    private void updateObjectsList(Map<Integer, List<T>> queues, Node<T> header, Integer parentId) {
        Node<T> node = header.next;
        List<T> arr = new ArrayList<>();
        while (node != null) {
            arr.add(node.object);
            node = node.next;
        }
        queues.put(parentId, arr);
    }

    private boolean isMaxPriority(int objectId) {
        final Node<T> cur = map.get(objectId);
        return cur != null && cur.pre == header;
    }

    private boolean isMinPriority(int objectId) {
        final Node<T> cur = map.get(objectId);
        return cur != null && cur.next == null;
    }

    /**
     * 1、找到节点
     * 2、前节点 == header 抛异常
     *
     * @param objectId 当前节点
     * @return 之前节点id
     */
    private int prePriorityId(int objectId) {
        if (isMaxPriority(objectId)) {
            throw new RuntimeException("极值");
        }
        final Node<T> node = map.get(objectId);
        T object = node.pre.object;
        try {
            return (int) idGet.invoke(object);
        } catch (Exception e) {
            throw new RuntimeException("反射出错", e);
        }
    }

    private int afterPriorityId(int objectId) {
        if (isMinPriority(objectId)) {
            throw new RuntimeException("极值");
        }
        final Node<T> node = map.get(objectId);
        T object = node.next.object;
        try {
            return (int) idGet.invoke(object);
        } catch (Exception e) {
            throw new RuntimeException("反射出错", e);
        }
    }

    /**
     * 找寻队列头
     *
     * @param t 找寻节点
     * @return 队列头
     */
    private Node<T> findQueueHeader(T t) {
        if (parentGet != null) {
            final Node<T> parent = findParentNode(t);
            if (parent != null) {
                if (parent.down == null) {
                    parent.down = new Node<>(null);
                }
                return parent.down;
            }
        }
        return header;
    }

    /**
     * 找寻父节点
     *
     * @param node 当前节点
     * @return 父节点
     */
    private Node<T> findParentNode(T node) {
        try {
            int parentId = (Integer) parentGet.invoke(node);
            if (parentId != TOP) {
                return map.get(parentId);
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("反射出错", e);
        }
    }

    private static class Node<T> {

        Node<T> pre;
        Node<T> next;
        Node<T> down;
        T object;

        Node(T object) {
            this.object = object;
        }

    }
}
