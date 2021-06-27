package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-24 16:06
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(
                        (i - j) * j, j * dp[i - j]
                ), dp[i]);
            }
        }
        return dp[n];
    }

}
