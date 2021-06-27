package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-04 11:04
 */
public class Jump {

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{2, 3, 1, 1, 4}));
    }

    //假设你总是可以到达数组的最后一个位置。
    public int jump(int[] nums) {
        // 跳到位置i的最小跳跃数。
        int[] dp = new int[nums.length];
        int target = nums.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < target; i++) {
            // 在i的基础上再跳一步到j时的最小跳跃数
            for (int j = i + 1; j < target; j++) {
                if (j <= i + nums[i]) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

}
