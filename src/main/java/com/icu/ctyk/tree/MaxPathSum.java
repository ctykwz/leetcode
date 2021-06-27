package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-18 21:39
 */
public class MaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = Integer.MIN_VALUE;
        return max;
    }

    private int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(max(root.left), 0);
        int right = Math.max(max(root.right), 0);
        max = Math.max(max, root.val + left + right);
        // 当前节点能选择的最大值
        return root.val + Math.max(left, right);
    }
}
