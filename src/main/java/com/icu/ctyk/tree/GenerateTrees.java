package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author ctykwz on 2021-06-27 21:09
 */
public class GenerateTrees {

    public static void main(String[] args) {
        System.out.println(new GenerateTrees().generateTrees(3));
    }

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    res.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return res;
    }
}
