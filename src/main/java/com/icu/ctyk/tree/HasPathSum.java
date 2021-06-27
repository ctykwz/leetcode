package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-16 22:13
 */
public class HasPathSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println(new HasPathSum().hasPathSum(root, 6));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

}
