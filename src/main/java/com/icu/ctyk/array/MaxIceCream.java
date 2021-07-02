package com.icu.ctyk.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 *
 * @author ctykwz on 2021-07-02 09:54
 */
public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        int[] dp = new int[coins + 1];

        for (int cost : costs) {
            for (int i = coins; i > 0; i--) {
                if (i >= cost) {
                    // 零钱兑换
                    dp[i] = Math.max(dp[i - cost] + 1, dp[i]);
                }
            }
        }
        return dp[coins];
    }


    public int maxIceCreamV2(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for (int cost : costs) {
            if (coins >= cost) {
                cnt += 1;
                coins -= cost;
            } else {
                break;
            }
        }
        return cnt;
    }
}
