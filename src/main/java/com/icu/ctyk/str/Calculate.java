package com.icu.ctyk.str;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/calculator-lcci/
 *
 * @author ctykwz on 2021-06-26 19:43
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(
                new Calculate().calculate("1+2*5/3+6/4*2")
        );
    }

    public int calculate(String s) {
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        char operation = '+';
        for (int i = 0; i <= s.length(); i++) {
            char token = i == s.length() ? '+' : s.charAt(i);
            if (token == ' ') {
                continue;
            }
            if (token >= '0' && token <= '9') {
                num.append(token);
            } else if (num.length() > 0) {
                int cur = Integer.parseInt(num.toString());
                switch (operation) {
                    case '+': {
                        queue.offerLast(cur);
                        break;
                    }
                    case '-': {
                        queue.offerLast(-cur);
                        break;
                    }
                    case '*': {
                        if (!queue.isEmpty()) {
                            queue.offerLast(queue.pollLast() * cur);
                        }
                        break;
                    }
                    case '/': {
                        if (!queue.isEmpty()) {
                            queue.offerLast(queue.pollLast() / cur);
                        }
                        break;
                    }
                }
                num = new StringBuilder();
                operation = token;
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }
        return res;
    }

}
