package com.lzx2005.training.leetcode;

public class SameTree {

    private Boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        isSameNode(p, q);
        return isSame;
    }

    private void isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
        } else if (p == null || q == null) {
            isSame = false;
        } else {
            if (p.val == q.val) {
                isSameNode(p.left, q.left);
                isSameNode(p.right, q.right);
            } else {
                isSame = false;
            }
        }
    }
}
