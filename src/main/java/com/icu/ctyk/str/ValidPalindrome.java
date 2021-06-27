package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-27 19:40
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // 出现一个不相同的字符 这个字符是可以删除的
                return valid(s, left + 1, right) || valid(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean valid(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
