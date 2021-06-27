package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-04 17:30
 */
public class MaxSubArrayV2 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum, 0) + num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
