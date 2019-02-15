package com.lzx2005.training.leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int count = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x + 2 * y == n) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new ClimbingStairs().climbStairs(3);
        System.out.println(i);
    }
}
