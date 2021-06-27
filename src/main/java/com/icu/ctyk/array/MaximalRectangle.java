package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-19 09:28
 */
public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        // i,j 的最大矩形
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (chars[i] == '1') {
                    height[i] += 1;
                } else {
                    height[i] = 0;
                }
            }
            max = Math.max(max, maxArea(height));
        }
        return max;
    }

    private int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int left = i;
            while (left > 0 && height[i] <= height[left - 1]) {
                left--;
            }
            int right = i;
            while (right < height.length - 1 && height[i] <= height[right + 1]) {
                right++;
            }
            res = Math.max((right - left + 1) * height[i], res);
        }
        return res;
    }

}
