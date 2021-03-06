package com.icu.ctyk.str;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author ctykwz on 2021-07-03 16:21
 */
public class LongestPalindromeSubseq {

        public int longestPalindromeSubseq(String s) {
            // 从 i->j 的最长回文串
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
}
