package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-10 16:45
 */
public class Change {

    public static void main(String[] args) {
        System.out.println(new Change().change(5, new int[]{1, 2, 5}));
    }


    // 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        // 金额为i时的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
