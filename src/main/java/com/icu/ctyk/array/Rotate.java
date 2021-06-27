package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @author ctykwz on 2021-06-18 19:26
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        new Rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }
}
