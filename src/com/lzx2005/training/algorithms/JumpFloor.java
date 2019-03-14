package com.lzx2005.training.algorithms;

/**
 * Created by Lizhengxian on 2017/3/16.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {

    public int JumpFloor(int target) {
        if(target<=0){
            return -1;
        }else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else{
            return JumpFloor(target-1)+JumpFloor(target-2);
        }
    }

    public int JumpFloorII(int target){
        return 1<<--target;
    }

    public static void main(String[] args) {
        int i = new JumpFloor().JumpFloor(4);
        System.out.println(i);
    }
}
