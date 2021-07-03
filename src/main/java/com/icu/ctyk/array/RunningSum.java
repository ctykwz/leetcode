package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-07-03 22:15
 */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
