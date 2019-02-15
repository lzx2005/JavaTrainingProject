package com.lzx2005.training.leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int sum = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                delete(nums, i);
                sum--;
            }
        }
        return sum;
    }

    private void delete(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
