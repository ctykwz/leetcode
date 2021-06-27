package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-20 10:47
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        boolean res = new IsBalanced().isBalanced(root);
        System.out.println(res);
    }

    public boolean isBalanced(TreeNode root) {
        return treeHeight(root) >= 0;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
