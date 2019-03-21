package com.lzx2005.training.dataStructure.graph;

import java.util.Iterator;

/**
 * Created by hzlizx on 2019/3/21
 */
public interface Graph {

    /**
     * 连接两个节点
     *
     * @param a 节点1
     * @param b 节点2
     */
    void connect(int a, int b);

    /**
     * 两个节点是否连接
     *
     * @param a 节点1
     * @param b 节点2
     * @return 是否连接
     */
    boolean isConnected(int a, int b);

    /**
     * 打印整个图
     */
    void print();

    /**
     * 得到节点X的迭代器
     * @param x 节点x
     * @return  迭代器
     */
    Iterator iterator(int x);
}
