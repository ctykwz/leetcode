package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-20 20:56
 */
public class Fib {

    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
