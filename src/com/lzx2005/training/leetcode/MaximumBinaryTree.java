package com.lzx2005.training.leetcode;

/**
 * Created by Lizhengxian on 2018/2/26.
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int idxMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[idxMax]) {
                idxMax = i;
            }
        }
        TreeNode treeNode = new TreeNode(nums[idxMax]);
        treeNode.left = build(nums, start, idxMax - 1);
        treeNode.right = build(nums, idxMax + 1, end);
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}