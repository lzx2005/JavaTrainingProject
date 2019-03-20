package com.lzx2005.training.dataStructure.unionFind;

/**
 * Created by hzlizx on 2019/3/20
 */
public class UFT {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        System.out.println(unionFind.isConnected(0,1));
        unionFind.union(0,1);
        System.out.println(unionFind.isConnected(0,1));
    }
}
