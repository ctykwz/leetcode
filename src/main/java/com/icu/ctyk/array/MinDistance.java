package com.icu.ctyk.array;

/**
 * @author ctykwz on 2021-06-18 23:17
 */
public class MinDistance {

    public static void main(String[] args) {
        int cnt = new MinDistance().minDistance("horse", "ros");
        System.out.println(cnt);
    }

    public int minDistance(String word1, String word2) {
        // 从word1 的 i 位置 到 word2的 j 位置需要最少操作次数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                // i-1,j-1 在word指字符的索引
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + 1
                    );
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }
}
