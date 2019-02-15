package com.lzx2005.training.leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int i = new SearchInsertPosition().searchInsert(nums, 0);
        System.out.println(i);
    }
}
