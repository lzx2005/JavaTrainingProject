package com.lzx2005.training.algorithms;

/**
 * Created by Lizhengxian on 2017/3/16.
 * 求斐波那契数列
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==0){
            return n;
        }
        int x1=1;
        int x2=1;
        for(int i=3;i<=n;i++){
            int x = x1+x2;
            x1=x2;
            x2=x;
        }
        return x2;
    }
}
