package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-17 19:34
 */
public class MaximalSquare {

    // 跟v1的不同在于这里重复数据只能用一次
    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        // 从i，j坐标时的最长正方形边长
        int[][] dp = new int[height][width];
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0 || i == 0) {
                        // 因为是正方形，而且位于边界 所以长度最大只会是1
                        dp[i][j] = 1;
                    } else {
                        // 上、左，左上
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
