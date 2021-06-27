package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-19 23:02
 */
public class Trap {

    public int trap(int[] height) {
        int res = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[height.length - 2] = height[height.length - 1];
        for (int i = height.length - 1; i > 0; i--) {
            right[i] = Math.max(height[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

}
