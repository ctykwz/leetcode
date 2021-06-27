package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ctykwz on 2021-06-27 16:58
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(root));
    }

    // 用节点记录当前的index，以便于计算宽度
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = Math.max(queue.peekLast().val - queue.peekFirst().val + 1, res);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

}
