package com.icu.ctyk.num;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 *
 * @author ctykwz on 2021-06-21 10:41
 */
public class DicesProbability {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DicesProbability().dicesProbability(4)));
        System.out.println(Arrays.stream(new DicesProbability().dicesProbability(4)).max().orElse(0.0));
    }

    /**
     * dp[i][j] i个骰子值为j的概率和
     *
     * @param n 骰子个数
     * @return 概率
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        // 第n次
        for (int i = 2; i <= n; i++) {
            double[] innerDp = new double[5 * i + 1];
            // 合为j的概率
            for (int j = 0; j < dp.length; j++) {
                for (int num = 0; num < 6; num++) {
                    innerDp[j + num] += dp[j] / 6.0;
                }
            }
            dp = innerDp;
        }
        return dp;
    }
}
