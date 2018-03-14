package com.lzx2005.training.leetcode;

import com.sun.tools.javac.util.List;

import java.util.Arrays;

/**
 *
 * Created by Lizhengxian on 2018/3/8.
 */


/**
 * 亲爱的维护者：
 *
 * 如果你尝试了对这段程序进行'优化'
 * 下面这个计数器用来对后来人进行警告
 *
 * 浪费在这里的总时间 = 42h
 */

public class ArrayPartitionI {


    public static void main(String[] args) {

        int[] s = {1,2,5,3,6,4};
        int i = new ArrayPartitionI().arrayPairSum(s);
        System.out.println(i);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=0;
        int sum = 0;
        while(n<nums.length){
            sum+=nums[n];
            n+=2;
        }
        return sum;
    }
}
