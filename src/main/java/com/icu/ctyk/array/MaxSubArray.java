package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-02 21:35
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArrayV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //位置为i时所能构造出的子数组和的最大值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //位置为i时所能构造出的子数组和的最大值
        int sum = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum, 0) + nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

}
