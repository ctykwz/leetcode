package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * @author ctykwz on 2021-07-03 20:25
 */
public class FindNumberOfLIS {

    public static void main(String[] args) {
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(
                new int[]{1, 3, 5, 4, 7})
        );
    }

    public int findNumberOfLIS(int[] nums) {
        int[] counter = new int[nums.length];
        // 以i结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(counter, 1);
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                res += counter[i];
            }
        }
        return res;
    }
}
