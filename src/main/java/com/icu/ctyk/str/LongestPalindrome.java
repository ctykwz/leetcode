package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-27 17:47
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 只含大小写
        int[] container = new int[58];
        for (char token : s.toCharArray()) {
            container[token - 'A']++;
        }
        int res = 0;
        boolean hasEnv = false;
        for (int cnt : container) {
            if (cnt == 0) {
                continue;
            }
            res += (cnt / 2) * 2;
            if (cnt % 2 != 0 && !hasEnv) {
                res += 1;
                hasEnv = true;
            }
        }
        return res;
    }
}
