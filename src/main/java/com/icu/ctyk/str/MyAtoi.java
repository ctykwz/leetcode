package com.icu.ctyk.str;

import java.util.Objects;

/**
 * @author ctykwz on 2021-06-27 11:27
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("-91283472332"));
    }


    public int myAtoi(String s) {
        Character op = null;
        boolean isHead = true;
        int val = 0;
        for (char token : s.toCharArray()) {
            if (isHead && token == ' ') {
                continue;
            }
            if ((token == '-' || token == '+') && isHead) {
                op = token;
                isHead = false;
            } else if (token >= '0' && token <= '9') {
                isHead = false;
                int tmp = val * 10 + token - '0';
                if (tmp / 10 != val) {
                    return Objects.equals(op, '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                val = tmp;

            } else {
                break;
            }
        }
        return Objects.equals(op, '-') ? -val : val;
    }
}
