package com.icu.ctyk.str;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-20 20:46
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (builder.length() > 0) {
                    stack.push(builder.toString());
                    builder = new StringBuilder();
                }
            } else {
                builder.append(c);
            }
        }
        if (builder.length() > 0) {
            stack.push(builder.toString());
        }
        StringBuilder res = new StringBuilder();
        int size = stack.size();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            size--;
            if (size != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
