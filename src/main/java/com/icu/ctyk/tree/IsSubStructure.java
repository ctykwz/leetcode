package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-20 14:50
 */
public class IsSubStructure {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        right.left = new TreeNode(1);
        Boolean res = new IsSubStructure().isSubStructure(root, right);
        System.out.println(res);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return dfs(A, B);
    }


    public boolean dfs(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (same(A, B)) {
            return true;
        }
        return dfs(A.left, B) || dfs(A.right, B);
    }

    private boolean same(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        return A.val == B.val && same(A.left, B.left) && same(A.right, B.right);
    }
}
