package com.icu.ctyk.tree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * @author ctykwz on 2021-06-21 22:09
 */
public class VerifyPostorder {

    // 这里的要求是 根节点大于左节点 小于右节点
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i > 0; i--) {
            // 第一个就是根节点
            if (root < postorder[i]) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                // 更新root节点
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

}
