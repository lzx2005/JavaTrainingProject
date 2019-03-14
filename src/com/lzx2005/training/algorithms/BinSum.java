package com.lzx2005.training.algorithms;

/**
 * Created by Lizhengxian on 2017/3/17.
 */
public class BinSum {
    public int count(int n){
        int sum=0;
        while (n!=0){
            sum+=n&1;
            n=n>>>1;
        }
        return sum;
    }

    public static void main(String[] args) {
        int count = new BinSum().count(223);
        System.out.println(count);
    }
}
