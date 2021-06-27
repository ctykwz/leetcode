package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-24 17:33
 */
public class IsInterleave {

    public static void main(String[] args) {
        System.out.println(new IsInterleave().isInterleave("", "", ""));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= s2.length() && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)
                        || dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
