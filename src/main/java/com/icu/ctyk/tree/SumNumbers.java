package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-27 12:10
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(new SumNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        int rootVal = pre * 10 + root.val;
        if (root.left == null && root.right == null) {
            return rootVal;
        }
        int left = dfs(root.left, rootVal);
        int right = dfs(root.right, rootVal);
        return left + right;
    }
}
