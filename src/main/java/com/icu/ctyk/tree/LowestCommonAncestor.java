package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * 3
 * / \
 * 5   1
 * / \ / \
 * 6  2 0  8
 * / \
 * 7   4
 *
 * @author ctykwz on 2021-06-23 21:46
 */
public class LowestCommonAncestor {

    private TreeNode ancestor;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor = null;
        isCommonAncestor(root, p, q);
        return ancestor;
    }

    private boolean isCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return false;
        }
        boolean leftRes = isCommonAncestor(root.left, left, right);
        boolean rightRes = isCommonAncestor(root.right, left, right);
        if ((leftRes && rightRes) ||
                (root.val == root.left.val || root.val == root.right.val) && (leftRes || rightRes)) {
            // 值连续的时候看最近的
            ancestor = root;
        }
        return leftRes || rightRes || (root.val == left.val || root.val == right.val);
    }

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorV2(root.left, p, q);
        TreeNode right = lowestCommonAncestorV2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode res = new LowestCommonAncestor().lowestCommonAncestorV3(root, new TreeNode(5), new TreeNode(10));
        System.out.println(res);
    }

    private TreeNode res;

    // q/p 之一可能为null 题里的节点值不会出现重复
    public TreeNode lowestCommonAncestorV3(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfsV3(root, p, q);
        return res;
    }

    private boolean dfsV3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfsV3(root.left, p, q);
        boolean right = dfsV3(root.right, p, q);
        if (left && right) {
            res = root;
            return true;
        }
        if ((left || right) && (root.val == p.val || root.val == q.val)) {
            res = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

}
