package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-06 14:53
 */
public class LongestConsecutiveV2 {

    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
    // 分别计算递增和递减的最大值
    private int[] dfs(TreeNode node) {
        if (Objects.isNull(node)) {
            return new int[]{0, 0};
        }
        int inc = 1;
        int desc = 1;
        if (Objects.nonNull(node.left)) {
            int[] leftRes = dfs(node.left);
            if (node.val == node.left.val + 1) {
                desc = leftRes[1] + 1;
            } else if (node.val == node.left.val - 1) {
                inc = leftRes[0] + 1;
            }
        }
        if (Objects.nonNull(node.right)) {
            int[] rightRes = dfs(node.right);
            if (node.val == node.right.val + 1) {
                desc = Math.max(desc, rightRes[1] + 1);
            } else if (node.val == node.right.val - 1) {
                inc = Math.max(inc, rightRes[0] + 1);
            }
        }
        max = Math.max(max, desc + inc - 1);
        return new int[]{inc, desc};
    }
}
