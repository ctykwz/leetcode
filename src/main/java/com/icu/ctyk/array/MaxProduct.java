package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-10 21:25
 */
public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{-2, 0, -1}));
    }


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 乘法的特殊在于两个负数相乘为正数
        int maxMulti = nums[0];
        int minMulti = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxValue = maxMulti * nums[i];
            int minValue = minMulti * nums[i];
            maxMulti = Math.max(Math.max(maxValue, nums[i]), minValue);
            minMulti = Math.min(Math.min(minValue, nums[i]), maxValue);
            max = Math.max(Math.max(maxMulti, minMulti), max);
        }
        return max;
    }
}
