package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ctykwz on 2021-06-24 11:17
 */
public class BuildTree106 {

    public static void main(String[] args) {
        TreeNode root = new BuildTree106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorderMap, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> inorderMap, int[] postorder,
                           int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft < 0 || inRight < 0 || inLeft > inRight) {
            return null;
        }
        int root = postorder[postRight];
        int rootIndex = inorderMap.get(root);

        TreeNode left = build(inorderMap, postorder,
                inLeft, rootIndex - 1, postLeft, postLeft + rootIndex - inLeft - 1);
        TreeNode right = build(inorderMap, postorder,
                rootIndex + 1, inRight,
                postLeft + rootIndex - inLeft, postRight - 1);
        TreeNode node = new TreeNode(root);
        node.right = right;
        node.left = left;
        return node;
    }


}
