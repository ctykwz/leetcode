package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-06 14:45
 */
public class LongestConsecutive {

    public int longestConsecutive(TreeNode root) {
        return maxLen(root, null, 0);
    }

    private int maxLen(TreeNode node, TreeNode before, int max) {
        if (Objects.isNull(node)) {
            return 0;
        }
        if (Objects.isNull(before) || node.val == before.val + 1) {
            max++;
        } else {
            max = 1;
        }
        return Math.max(max, Math.max(maxLen(node.left, node, max), maxLen(node.right, node, max)));
    }
}
