package com.icu.ctyk.str;

/**
 * @author ctykwz on 2021-06-05 21:45
 */
public class CheckValidString {

    public static void main(String[] args) {
        System.out.println(new CheckValidString().checkValidString("(***)"));
    }

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            left += s.charAt(i) == ')' ? -1 : 1;
            right += s.charAt(s.length() - 1 - i) == '(' ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValidStringV2(String s) {
        int left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            left += (s.charAt(i) == ')') ? -1 : 1;
            right += (s.charAt(n - i - 1) == '(') ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }
}
