package com.lzx2005.training.leetcode;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int sum = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                delete(nums, i - 1);
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

    public static void main(String[] args) {
        int[] nu = {1, 3, 5, 6, 6, 7, 8, 8, 9};
        int i1 = new RemoveDuplicatesFromSortedArray().removeDuplicates(nu);
        System.out.println(i1);
        for (int i : nu) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
