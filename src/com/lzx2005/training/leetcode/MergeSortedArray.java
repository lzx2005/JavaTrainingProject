package com.lzx2005.training.leetcode;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, index = 0;
        int[] temp = new int[nums1.length];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[index++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                temp[index++] = nums2[j++];
            } else {
                temp[index++] = nums1[i++];
                temp[index++] = nums2[j++];
            }
        }
        for (; i < m; i++) {
            temp[index++] = nums1[i];
        }
        for (; j < n; j++) {
            temp[index++] = nums2[j];
        }
        for (int index1 = 0; index1 < temp.length; index1++) {
            nums1[index1] = temp[index1];
        }
    }
}
