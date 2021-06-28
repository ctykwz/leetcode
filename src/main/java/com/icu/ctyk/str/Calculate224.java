package com.icu.ctyk.str;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 *
 * @author ctykwz on 2021-06-28 21:47
 */
public class Calculate224 {

    //s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> operation = new Stack<>();
        operation.push(1);
        int sign = 1;
        int res = 0;
        StringBuilder num = new StringBuilder();
        for (char token : s.toCharArray()) {
            if (token >= '0' && token <= '9') {
                num.append(token);
                continue;
            }
            if (num.length() > 0) {
                res += sign * Integer.parseInt(num.toString());
            }
            num.setLength(0);
            switch (token) {
                case '+': {
                    sign = operation.peek();
                    break;
                }
                case '-': {
                    sign = -operation.peek();
                    break;
                }
                case '(': {
                    operation.push(sign);
                    break;
                }
                case ')': {
                    operation.pop();
                    break;
                }
                default: {
                    break;
                }
            }
        }
        if (num.length() > 0) {
            res += sign * Integer.parseInt(num.toString());
        }
        return res;
    }


}
