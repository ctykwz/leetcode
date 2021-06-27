package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-20 10:12
 */
public class Flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new Flatten().flatten(root);
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        dfs(left);
        TreeNode right = root.right;
        dfs(right);
        if (left != null) {
            TreeNode leftTail = left;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            leftTail.right = right;
            root.right = left;
            root.left = null;
        }
    }
}
