package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-17 19:55
 */
public class CountSquares {


    public static void main(String[] args) {
        System.out.println(
                new CountSquares().countSquares(
                        new int[][]{
                                new int[]{0, 1, 1, 1},
                                new int[]{1, 1, 1, 1},
                                new int[]{0, 1, 1, 1},
                        }
                )
        );
    }

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // i,j 所能组成的正方形数
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // 边界
                        dp[i][j] = 1;
                    } else {
                        // 因为要是正方形，所以左，上，左上的正方形应该至少有一定交集，那么如果当前也是1，那么当前点位的正方形会+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
