package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

/**
 * @author ctykwz on 2021-06-25 18:29
 */
public class RecoverTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new RecoverTree().recoverTree(root);
    }

    private TreeNode first;
    private TreeNode pre;
    private TreeNode sec;

    public void recoverTree(TreeNode root) {
        check(root);
        int val = first.val;
        first.val = sec.val;
        sec.val = val;
    }


    private void check(TreeNode node) {
        if (node == null) {
            return;
        }
        check(node.left);
        if (first == null && pre != null && pre.val > node.val) {
            first = pre;
        }
        if (first != null && pre != null && pre.val > node.val) {
            sec = node;
        }
        pre = node;
        check(node.right);
    }
}
