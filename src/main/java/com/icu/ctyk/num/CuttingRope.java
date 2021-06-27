package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-20 21:59
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(120));
    }

    public int cuttingRope(int n) {
        // 长度为i 的绳子能够获取的最大乘积数
        long[] dp = new long[n + 1];
        dp[1] = 1;
        // 至少要减2次
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(
                        // 0~j 裁剪获取的最大值和不裁剪获取的最大值
                        Math.max(dp[j], j) * (i - j),
                        dp[i]

                );
            }
        }
        return (int) (dp[n]%1000000007);
    }
}
