package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-28 22:57
 */
public class IsPalindrome {


    public static void main(String[] args) {
        System.out.println(
                new IsPalindrome().isPalindrome("0P")
        );
    }

    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            char token;
            while (left < right
                    && !((token = Character.toLowerCase(s.charAt(left))) >= 'a' && token <= 'z'
                    || token >= '0' && token <= '9')) {
                left += 1;
            }
            while (right > left && !((token = Character.toLowerCase(s.charAt(right))) >= 'a' && token <= 'z'
                    || token >= '0' && token <= '9')) {
                right -= 1;
            }
            if (right < s.length()
                    && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
