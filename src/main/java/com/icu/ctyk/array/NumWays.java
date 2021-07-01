package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ctykwz on 2021-07-01 08:45
 */
public class NumWays {

    public int numWays(int n, int[][] relation, int k) {
        // 第i轮传到j的方案数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        for (int i = 0; i < k; i++) {
            for (int[] item : relation) {
                int from = item[0];
                int to = item[1];
                // 传递到from的方案数和即i+1到to的方案和
                dp[i + 1][to] += dp[i][from];
            }
        }
        return dp[k][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new NumWays().numWaysV2(
                5,
                new int[][]{
                        new int[]{0, 2}, new int[]{2, 1}, new int[]{3, 4}, new int[]{2, 3}, new int[]{1, 4}, new int[]{2, 0},
                        new int[]{0, 4}
                },
                3
        ));
    }

    public int numWaysV2(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] item : relation) {
            edges.computeIfAbsent(item[0], it -> new ArrayList<>()).add(item[1]);
        }
        AtomicInteger cnt = new AtomicInteger();
        dfs(edges, 0, k, n, cnt);
        return cnt.get();
    }

    // 从0开始遍历到n-1
    private void dfs(Map<Integer, List<Integer>> edges, int from, int k, int n, AtomicInteger cnt) {
        // 第k轮结束
        if (k == 0) {
            if (from == n - 1) {
                //能到达n-1的 计数
                cnt.incrementAndGet();
            }
            return;
        }
        if (!edges.containsKey(from)) {
            return;
        }
        for (Integer desc : edges.get(from)) {
            dfs(edges, desc, k - 1, n, cnt);
        }
    }

    public int numWaysV3(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] item : relation) {
            edges.get(item[0]).add(item[1]);
        }
        AtomicInteger cnt = new AtomicInteger();
        dfs(edges, 0, k, n, cnt);
        return cnt.get();
    }

    // 从0开始遍历到n-1
    private void dfs(List<List<Integer>> edges, int from, int k, int n, AtomicInteger cnt) {
        // 第k轮结束
        if (k == 0) {
            if (from == n - 1) {
                //能到达n-1的 计数
                cnt.incrementAndGet();
            }
            return;
        }
        for (Integer desc : edges.get(from)) {
            dfs(edges, desc, k - 1, n, cnt);
        }
    }
}
