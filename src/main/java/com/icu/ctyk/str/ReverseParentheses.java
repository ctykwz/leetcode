package com.icu.ctyk.str;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * @author ctykwz on 2021-06-28 11:21
 */
public class ReverseParentheses {

    public static void main(String[] args) {
        System.out.println(new ReverseParentheses().reverseParentheses(
                "a(bcdefghijkl(mno)p)q"
        ));
    }

    public String reverseParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char token : s.toCharArray()) {
            if (token == '(') {
                stack.push(builder.toString());
                builder = new StringBuilder();
            } else if (token != ')') {
                builder.append(token);
            } else {
                builder.reverse();
                if (!stack.isEmpty()) {
                    builder.insert(0, stack.pop());
                }
            }
        }
        return builder.toString();
    }
}
