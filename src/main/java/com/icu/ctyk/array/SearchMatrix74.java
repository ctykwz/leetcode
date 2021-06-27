package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-20 11:07
 */
public class SearchMatrix74 {

    public static void main(String[] args) {
        System.out.println(
                new SearchMatrix74().searchMatrix(
                        new int[][]{
                                new int[]{1, 2, 3, 7},
                                new int[]{10, 11, 16, 20},
                                new int[]{23, 30, 34, 60},
                        },
                        3
                )
        );
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            }
            if (value < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
