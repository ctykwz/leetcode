package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-05 19:59
 */
public class RobV2 {

    public static void main(String[] args) {
        System.out.println(new RobV2().rob(new int[]{2}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    public int robRange(int[] nums, int from, int to) {
        if (nums == null || nums.length == 0 || from > to) {
            return 0;
        }
        if (from == to) {
            return nums[from];
        }

        int[] dp = new int[to - from + 1];
        dp[0] = nums[from];
        dp[1] = Math.max(nums[from], nums[from + 1]);
        for (int i = from + 2; i <= to; i++) {
            dp[i - from] = Math.max(dp[i - 2 - from] + nums[i], dp[i - from - 1]);
        }
        return dp[dp.length - 1];
    }
}
