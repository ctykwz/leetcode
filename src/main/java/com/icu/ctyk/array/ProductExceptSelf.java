package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author ctykwz on 2021-06-27 17:35
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
            } else {
                left[i] = nums[i - 1] * left[i - 1];
            }
        }
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == nums.length - 1) {
                right[i] = 1;
            } else {
                right[i] = nums[i + 1] * right[i + 1];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
