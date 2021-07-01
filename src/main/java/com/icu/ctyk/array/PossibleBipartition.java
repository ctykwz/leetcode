package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 886. 可能的二分法
 * 给定一组N人（编号为1, 2, ..., N），我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 * @author ctykwz on 2021-07-01 11:28
 */
public class PossibleBipartition {

    public static void main(String[] args) {
        System.out.println(new PossibleBipartition().possibleBipartition(
                4,
                new int[][]{
                        new int[]{1, 2},
                        new int[]{1, 3},
                        new int[]{2, 4}
                }
        ));
    }

    //N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dislike : dislikes) {
            graph.computeIfAbsent(dislike[0], it -> new ArrayList<>()).add(dislike[1]);
            graph.computeIfAbsent(dislike[1], it -> new ArrayList<>()).add(dislike[0]);
        }
        Map<Integer, Boolean> color = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            // 没染过色 染色看下是否能够成功
            if (!color.containsKey(i) && paint(graph, color, i, true)) {
                return false;
            }
        }
        return true;
    }

    private boolean paint(Map<Integer, List<Integer>> graph, Map<Integer, Boolean> nodeColor, int from, boolean sameColor) {
        if (nodeColor.containsKey(from)) {
            return nodeColor.get(from) != sameColor;
        }
        nodeColor.put(from, sameColor);
        if (graph.containsKey(from)) {
            for (Integer item : graph.get(from)) {
                if (paint(graph, nodeColor, item, !sameColor)) {
                    return true;
                }
            }
        }
        return false;
    }

}
