package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-05 20:17
 */
public class Rob {

    public int rob(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int[] result = robNode(root);
        return Math.max(result[0], result[1]);
    }

    // 对于一个节点只有两个状态 偷:不偷 ，如果偷了根节点就不能偷子节点
    private int[] robNode(TreeNode node) {
        if (Objects.isNull(node)) {
            return new int[]{0, 0};
        }
        int[] robLeft = robNode(node.left);
        int[] robRight = robNode(node.right);
        int robSelf = node.val + robLeft[0] + robRight[0];
        int unRobSelf = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        return new int[]{unRobSelf, robSelf};
    }
}
