package com.lzx2005.training.dataStructure.unionFind;

/**
 * Created by hzlizx on 2019/3/20
 */
public class UnionFind {

    private int[] parent;
    private int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (rank[pRoot] < rank[qRoot]) {
                rank[pRoot] = rank[qRoot];
                parent[pRoot] = qRoot;
            } else if (rank[qRoot] < rank[pRoot]) {
                rank[qRoot] = rank[pRoot];
                parent[qRoot] = pRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[pRoot] = rank[qRoot] += 1;
            }
        }
    }
}
