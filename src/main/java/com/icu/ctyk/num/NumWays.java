package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-10 16:40
 */
public class NumWays {

    public static void main(String[] args) {
        System.out.println(new NumWays().numWays(7));
    }

    public int numWays(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
