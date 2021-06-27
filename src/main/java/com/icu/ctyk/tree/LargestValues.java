package com.icu.ctyk.tree;

import com.icu.ctyk.tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author ctykwz on 2021-06-02 11:25
 */
public class LargestValues {

    // bfs
    public List<Integer> largestValues(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    max = Math.max(node.val, max);
                    if (Objects.nonNull(node.left)) {
                        queue.offer(node.left);
                    }
                    if (Objects.nonNull(node.right)) {
                        queue.offer(node.right);
                    }
                }
            }
            result.add(max);
        }
        return result;
    }
}
