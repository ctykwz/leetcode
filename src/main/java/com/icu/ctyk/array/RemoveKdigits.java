package com.icu.ctyk.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ctykwz on 2021-06-17 11:01
 */
public class RemoveKdigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKdigits().removeKdigits("112", 1));
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!queue.isEmpty() && k > 0 && queue.peekLast() > num.charAt(i)) {
                queue.pollLast();
                k--;
            }
            queue.offerLast(num.charAt(i));
        }
        if (k > 0) {
            for (int i = 0; i <= k; i++) {
                queue.pollLast();
            }
        }
        StringBuilder builder = new StringBuilder();
        boolean hasZero = true;
        for (Character character : queue) {
            if (hasZero && character == '0') {
                continue;
            }
            hasZero = false;
            builder.append(character);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
