package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-10 21:12
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        System.out.println(
                new FindNumberIn2DArray().findNumberIn2DArray(
                        new int[][]{
                                new int[]{1, 4, 7, 11, 15},
                                new int[]{2, 5, 8, 12, 19},
                                new int[]{3, 6, 9, 16, 22},
                                new int[]{10, 13, 14, 17, 24},
                                new int[]{18, 21, 23, 26, 30},

                        }, 5)
        );
        System.out.println(
                new FindNumberIn2DArray().findNumberIn2DArray(
                        new int[][]{
                                new int[]{-5}

                        }, -5)
        );
    }

    // 一旦某个数比当前target大  那么right++、top++的数据都不用再看
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int right = matrix[0].length - 1;
        int top = 0;
        while (right >= 0 && top < matrix.length) {
            if (matrix[top][right] == target) {
                return true;
            }
            if (matrix[top][right] > target) {
                right--;
            } else {
                top++;
            }
        }
        return false;
    }
}
