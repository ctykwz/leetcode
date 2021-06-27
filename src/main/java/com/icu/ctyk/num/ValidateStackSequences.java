package com.icu.ctyk.num;

import java.util.Stack;

/**
 * @author ctykwz on 2021-06-21 20:16
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences().validateStackSequences(
                new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}
        ));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
