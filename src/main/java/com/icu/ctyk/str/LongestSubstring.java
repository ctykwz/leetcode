package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-27 15:28
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().longestSubstring("ababbc", 2));
    }

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int[] counter = new int[26];
        for (char token : s.toCharArray()) {
            counter[token - 'a']++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0 && counter[i] < k) {
                int res = 0;
                char split = (char) (i + 'a');
                for (String part : s.split(String.valueOf(split))) {
                    res = Math.max(res, longestSubstring(part, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
