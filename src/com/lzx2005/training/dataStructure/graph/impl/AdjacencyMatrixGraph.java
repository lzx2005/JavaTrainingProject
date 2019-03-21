package com.lzx2005.training.dataStructure.graph.impl;

import com.lzx2005.training.dataStructure.graph.Graph;

import java.util.Iterator;

/**
 * 邻接矩阵实现
 * Created by hzlizx on 2019/3/21
 */
public class AdjacencyMatrixGraph implements Graph {

    //总共有几个节点
    private int n;
    //总共有几条边
    private int m;
    //邻接矩阵存储
    private boolean[][] g;
    //是否为有向图
    private boolean oriented;

    //构造方法
    public AdjacencyMatrixGraph(int n, boolean oriented) {
        this.n = n;
        this.m = 0;
        this.oriented = oriented;
        this.g = new boolean[n][n];
    }

    @Override
    public void connect(int a, int b) {
        assert a > 0 && a < n;
        assert b > 0 && b < n;
        if (isConnected(a, b)) {
            return;
        }
        g[a][b] = true;
        if (!oriented) {
            g[b][a] = true;
        }
        m++;
    }

    @Override
    public boolean isConnected(int a, int b) {
        assert a > 0 && a < n;
        assert b > 0 && b < n;
        // a -> b
        if (oriented) {
            return g[a][b];
        }
        return g[b][a];
    }

    @Override
    public void print() {
        System.out.print("\t");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print((g[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator iterator(int x) {
        assert x > 0 && x < n;
        return new GraphIterator(g[x]);
    }

    private class GraphIterator implements Iterator {
        boolean[] booleans;
        int index = 0;

        GraphIterator(boolean[] booleans) {
            this.booleans = booleans;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < booleans.length;
        }

        @Override
        public Object next() {
            return booleans[index++];
        }
    }
}
