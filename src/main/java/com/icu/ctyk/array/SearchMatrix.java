package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-19 16:31
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom = matrix.length - 1;
        int column = 0;
        while (column < matrix[0].length && bottom > 0) {
            if (matrix[bottom][column] == target) {
                return true;
            } else if (matrix[bottom][column] > target) {
                bottom--;
            } else {
                column++;
            }
        }
        return false;
    }
}
