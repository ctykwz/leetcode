package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ctykwz on 2021-06-02 10:09
 */
public class BuildTree {

    public static void main(String[] args) {
        TreeNode result = buildTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
        System.out.println(result);
    }

    // 前序遍历preorder: 先根节点再左节点再右节点
    // 中序遍历inorder：先左节点，再右节点
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (Objects.isNull(preorder) || Objects.isNull(inorder) || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildSubTree(inorderIndex, preorder, 0, preorder.length - 1, 0);
    }

    private static TreeNode buildSubTree(Map<Integer, Integer> inorderIndexMap, int[] preorder, int preLeft,
                                         int preRight, int inLeft) {
        if (preRight < preLeft) {
            return null;
        }
        int rootVal = preorder[preLeft];
        // 获取左子叶到根节点距离
        int distance = inorderIndexMap.get(rootVal) - inLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildSubTree(inorderIndexMap, preorder, preLeft + 1, preLeft + distance, inLeft);
        root.right = buildSubTree(inorderIndexMap, preorder, preLeft + distance + 1, preRight, inLeft + distance + 1);
        return root;
    }
}
