package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-27 21:35
 */
public class KthSmallest {

    // 二叉搜索树 的中序遍历是一个递增的
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (true) {
            while (root != null) {
                queue.add(root);
                root = root.left;
            }
            root = queue.poll();
            if (root == null) {
                continue;
            }
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        int res = new KthSmallest().kthSmallestV1(root, 2);
        System.out.println(res);
    }

    private static int res = 0;
    private static int cnt = 0;

    public int kthSmallestV1(TreeNode root, int k) {
        res = Integer.MIN_VALUE;
        cnt = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null || cnt < 0) {
            return;
        }
        dfs(node.left);
        cnt -= 1;
        if (cnt == 0) {
            res = node.val;
        }
        dfs(node.right);
    }
}
