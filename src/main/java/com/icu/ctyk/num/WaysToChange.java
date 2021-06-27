package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-27 16:44
 */
public class WaysToChange {

    public static void main(String[] args) {
        System.out.println(new WaysToChange().waysToChange(10));
    }

    private static final int[] coins = new int[]{25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i >= coin) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
