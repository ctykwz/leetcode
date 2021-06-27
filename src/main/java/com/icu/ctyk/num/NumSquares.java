package com.icu.ctyk.num;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ctykwz on 2021-06-11 22:09
 */
public class NumSquares {

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        // 和为i时的最少完全平方数数量       对于数i  和为n*n 需要 容量-当前数的平方
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        double max = Math.sqrt(n);
        for (int num = 1; num <= max; num++) {
            int left = num * num;
            for (int capacity = 0; capacity <= n; capacity++) {
                if (capacity >= left) {
                    // j-num*num >0 完全背包，外层物品，内层容量
                    dp[capacity] = Math.min(dp[capacity], dp[capacity - num * num] + 1);
                }
            }
        }
        return dp[n];
    }
}
