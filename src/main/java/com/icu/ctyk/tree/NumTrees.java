package com.icu.ctyk.tree;

/**
 * @author ctykwz on 2021-06-27 21:28
 */
public class NumTrees {

    public int numTrees(int n) {
        // 长度为 i 时所能构成的二叉树数量
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // [0,j-1] j [j+1,i]
                dp[i] += dp[i - j] + dp[j - 1];
            }
        }
        return dp[n];
    }
}
