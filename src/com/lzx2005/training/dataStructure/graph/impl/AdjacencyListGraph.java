package com.lzx2005.training.dataStructure.graph.impl;

import com.lzx2005.training.dataStructure.graph.Graph;

import java.util.LinkedList;

/**
 * 邻接表实现
 * Created by hzlizx on 2019/3/21
 */
public class AdjacencyListGraph implements Graph {

    //总共有几个节点
    private int n;
    //总共有几条边
    private int m;
    //邻接矩阵存储
    private LinkedList[] g;
    //是否为有向图
    private boolean oriented;

    public AdjacencyListGraph(int n, boolean oriented) {
        this.n = n;
        this.m = 0;
        this.oriented = oriented;
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList();
        }
    }

    @Override
    public void connect(int a, int b) {
        // a -> b
        assert a > 0 && a < n;
        assert b > 0 && b < n;
        if (isConnected(a, b)) {
            return;
        }
        g[a].add(b);
        if (!oriented) {
            g[b].add(a);
        }
        m++;
    }

    @Override
    public boolean isConnected(int a, int b) {
        assert a > 0 && a < n;
        assert b > 0 && b < n;
        if (oriented) {
            return g[a].contains(b);
        }
        return g[b].contains(a);
    }

    @Override
    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t");
            LinkedList linkedList = g[i];
            linkedList.forEach(point -> {
                System.out.print(point + "\t");
            });
            System.out.println();
        }
    }
}
