package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-27 14:56
 */
public class CountNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(new CountNodes().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            // 因为遍历的是左子树，这里相等 说明左树一定是满的
            return (1 << left) + countNodes(root.right);
        } else {
            // 右树一定是满的
            return (1 << right) + countNodes(root.left);
        }
    }

    private int depth(TreeNode node) {
        int res = 0;
        while (node != null) {
            res += 1;
            node = node.left;
        }
        return res;
    }
}
