package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-07-03 22:30
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return same(root.left, root.right);
    }

    private boolean same(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return same(left.right, right.left) && same(left.left, right.right);
    }
}
