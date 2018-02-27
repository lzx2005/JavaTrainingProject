package com.lzx2005.training.leetcode;

/**
 * Created by Lizhengxian on 2018/2/26.
 */
public class MaximumBinaryTree {



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null) t1 = new TreeNode(0);
        if(t2 == null) t2 = new TreeNode(0);
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left,t2.left);
        treeNode.right = mergeTrees(t1.right,t2.right);
        return treeNode;
    }

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