package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-23 09:52
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("$#");
        for (char zChar : s.toCharArray()) {
            builder.append(zChar).append("#");
        }
        builder.append("%");
        // index 为i时的最大子串半径
        int[] dp = new int[builder.length()];
        int res = 0;
        int center = 0;
        int right = 0;

        for (int i = 1; i < builder.length() - 1; i++) {
            // 如果
            dp[i] = (i <= right) ? Math.min(right - i + 1, dp[2 * center - i]) : 1;
            while (builder.charAt(dp[i] + i) == builder.charAt(i - dp[i])) {
                ++dp[i];
            }
            if (right < i + dp[i] - 1) {
                right = i + dp[i] - 1;
                center = i;
            }
            res += dp[i] / 2;
        }

        return res;
    }
}
