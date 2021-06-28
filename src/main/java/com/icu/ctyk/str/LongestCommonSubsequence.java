package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-05 23:27
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(
                "abcde",
                "ace"
        ));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        // 从text1的前i个字符到text2的前j个字符 最长公共子串
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); ++i) {
            for (int j = 1; j <= text2.length(); ++j) {
                // 为了方便  这里没有从0开始，取i-1字符和j-1字符作为 dp[i][j]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
