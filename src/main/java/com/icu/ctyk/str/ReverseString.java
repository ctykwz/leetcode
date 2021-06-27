package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-26 13:23
 */
public class ReverseString {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }

    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
