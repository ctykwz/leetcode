package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author ctykwz on 2021-06-21 09:23
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return res.stream().mapToInt(it -> it).toArray();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new LevelOrder().levelOrderV2(root));
    }

    public List<List<Integer>> levelOrderV2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<List<Integer>> res = new LinkedList<>();
        boolean fromLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> layer = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (fromLeft){
                    layer.addLast(node.val);
                }else {
                    layer.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            fromLeft = !fromLeft;
            res.add(layer);
        }
        return res;
    }
}
