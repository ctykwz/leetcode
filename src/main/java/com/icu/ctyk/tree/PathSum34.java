package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-20 12:13
 */
public class PathSum34 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new PathSum34().pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int target, int sum) {
        if (root == null) {
            if (target == sum && !tmp.isEmpty()) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        tmp.add(root.val);
        if (!(root.left == null && root.right != null)) {
            dfs(res, tmp, root.left, target, sum + root.val);
        }
        if (!(root.left == null && root.right == null) && !(root.left != null && root.right == null)) {
            dfs(res, tmp, root.right, target, sum + root.val);
        }
        tmp.remove(tmp.size() - 1);
    }
}
