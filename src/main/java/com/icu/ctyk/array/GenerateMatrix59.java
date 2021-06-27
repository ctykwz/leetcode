package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-20 11:42
 */
public class GenerateMatrix59 {


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new GenerateMatrix59().generateMatrix(5)));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int bottom = n - 1;
        int right = n - 1;
        int left = 0;
        int top = 0;
        int start = 1;
        int total = n * n;
        while (start <= total) {
            for (int i = left; i <= right; i++) {
                res[top][i] = start++;
            }
            for (int i = top + 1; i < bottom; i++) {
                res[i][right] = start++;
            }
            for (int i = right; i > left && start <= total; i--) {
                res[bottom][i] = start++;
            }
            for (int i = bottom; i > top && start <= total; i--) {
                res[i][left] = start++;
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }
}
