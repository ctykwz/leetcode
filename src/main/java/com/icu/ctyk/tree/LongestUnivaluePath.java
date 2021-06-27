package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-11 18:10
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }

    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        longestCommonPath(root);
        return res;
    }

    /**
     * 最长连续相同的长度
     *
     * @param root
     * @return
     */
    public int longestCommonPath(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = longestCommonPath(root.left);
        int right = longestCommonPath(root.right);
        if (root.left != null && root.val == root.left.val) {
            left += 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right += 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }

}
