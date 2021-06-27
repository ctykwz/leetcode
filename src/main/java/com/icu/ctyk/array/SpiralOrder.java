package com.icu.ctyk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ctykwz on 2021-06-05 19:03
 */
public class SpiralOrder {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SpiralOrder()
                .spiralOrder(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}})));
    }


    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int len = matrix.length * matrix[0].length;
        int[] result = new int[matrix.length * matrix[0].length];
        int cnt = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[cnt++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[cnt++] = matrix[i][right];
            }
            for (int i = right - 1; i >= left && cnt < len; i--) {
                result[cnt++] = matrix[bottom][i];
            }
            for (int i = bottom - 1; i > top && cnt < len; i--) {
                result[cnt++] = matrix[i][left];
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return result;
    }

    public List<Integer> spiralOrderV2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        if (matrix.length == 1) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return result;
    }
}
