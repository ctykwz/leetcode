package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-07-01 10:41
 */
public class DeleteNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        new DeleteNode().deleteNode(root, 7);
    }

    //删除二叉搜索树中的节点 核心点：二叉搜索树的中序遍历是自增的
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 值相等 处理左右节点
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = findMinRight(root);
                // 删除找到的右节点中的最小节点
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = findMaxLeft(root);
                // 删除找到的左节点中的最大节点
                root.left = deleteNode(root.left, root.val);
            }

        }
        return root;
    }

    // 找右节点中的最小值
    private int findMinRight(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // 找左节点中的最大值，也就是左节点中的右节点最后一个值
    private int findMaxLeft(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
