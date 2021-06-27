package com.icu.ctyk.num;

/**
 * @author ctykwz on 2021-06-24 09:27
 */
public class TranslateNum {

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(419605557));
    }

    public int translateNum(int num) {
        String tmp = Integer.toString(num);
        if (tmp.length() <= 1) {
            return 1;
        }
        int[] dp = new int[tmp.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= tmp.length(); i++) {
            if (tmp.charAt(i - 2) == '1' || tmp.charAt(i - 2) == '2' && tmp.charAt(i - 1) <= '5') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[tmp.length()];
    }
}
