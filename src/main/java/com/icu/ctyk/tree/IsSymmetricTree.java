package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.LinkedList;

/**
 * @author ctykwz on 2021-06-19 08:32
 */
public class IsSymmetricTree {

    public boolean isSymmetricV2(TreeNode root) {
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollFirst();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
