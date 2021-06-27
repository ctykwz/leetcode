package com.icu.ctyk.str;

/**
 * kmp
 *
 * @author ctykwz on 2021-06-06 15:59
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello","elelo"));
    }

    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] getNext(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return new int[]{};
        }
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
