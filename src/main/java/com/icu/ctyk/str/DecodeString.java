package com.icu.ctyk.str;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-19 21:28
 */
public class DecodeString {


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c5[g]]]"));
    }

    public String decodeString(String s) {
        Stack<StringBuilder> resStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char zChar : s.toCharArray()) {
            if (zChar == '[') {
                numStack.push(num);
                resStack.push(res);
                num = 0;
                res = new StringBuilder();
            } else if (zChar == ']') {
                int times = numStack.pop();
                StringBuilder tmp = new StringBuilder();
                while (times-- > 0) {
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.pop()).append(tmp);
            } else if (zChar >= '0' && zChar <= '9') {
                num = num * 10 + zChar - '0';
            } else {
                res.append(zChar);
            }
        }
        return res.toString();
    }
}
