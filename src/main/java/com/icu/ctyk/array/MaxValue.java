package com.icu.ctyk.array;

/**
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @author ctykwz on 2021-06-21 22:39
 */
public class MaxValue {

    public static void main(String[] args) {
        System.out.println(new MaxValue().maxValue(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                ) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
