package com.icu.ctyk.str;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * s1的排列是s2的子串，那么如果满足条件的话，s1各个字符出现的频率一定跟s2的某个区间段一致
 *
 * @author ctykwz on 2021-07-01 11:57
 */
public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion(
                "ab", "eidboaoo"
        ));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] first = new int[26];
        int[] sec = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            sec[s2.charAt(i) - 'a'] += 1;
            if (i < s1.length()) {
                first[s1.charAt(i) - 'a'] += 1;
            } else {
                sec[s2.charAt(i - s1.length()) - 'a'] -= 1;
            }
            if (i >= s1.length() - 1 && valid(first, sec)) {
                return true;
            }
        }
        return false;
    }

    // check 字符出现的次数是否一致：有效长度就是s1的长度
    private boolean valid(int[] left, int[] right) {
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }
}
