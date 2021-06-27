package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-03 15:10
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] val = new int[][]{new int[]{2, 3}};
        System.out.println(Arrays.toString(new FindDiagonalOrder().findDiagonalOrder(val)));
    }

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null) {
            return null;
        }
        int size = mat.length + mat[0].length - 2;
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        for (int i = 0; i <= size; i++) {
            if (i % 2 == 0) {
                int xAxis = i >= mat.length ? mat.length - 1 : i;
                int yAxis = i - xAxis;
                while (xAxis >= 0 && yAxis < mat[0].length) {
                    result[index++] = mat[xAxis][yAxis];
                    System.out.println(mat[xAxis][yAxis]);
                    xAxis--;
                    yAxis++;

                }
            } else {
                int yAxis = i >= mat[0].length ? mat[0].length - 1 : i;
                int xAxis = i - yAxis;
                while (yAxis >= 0 && xAxis < mat.length) {
                    result[index++] = mat[xAxis][yAxis];
                    System.out.println(mat[xAxis][yAxis]);
                    yAxis--;
                    xAxis++;
                }
            }
        }
        return result;
    }
}
