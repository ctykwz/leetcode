package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ctykwz on 2021-06-19 22:54
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        System.out.println(new PreorderTraversal().preorderTraversal(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left, res);
        dfs(node.right, res);
    }
}
