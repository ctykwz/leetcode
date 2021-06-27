package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-05 13:41
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> layer = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    layer.offerLast(node.val);
                } else {
                    layer.offerFirst(node.val);
                }
                if (Objects.nonNull(node.left)) {
                    queue.offer(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            result.add(new ArrayList<>(layer));
        }
        return result;
    }
}
